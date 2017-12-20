package com.nicahost.common.config.init.plugin;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.nicahost.common.config.bean.InitModuleBean;
import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.config.bean.InitPluginBean;
import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.config.init.Log4JInit;
import com.nicahost.common.dao.PropertiesBaseDAO;
import com.nicahost.common.dao.XMLBaseDAO;
import com.nicahost.common.exception.InitException;
import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;
/**
 * Clase de inicialización del back end de SBE. Esta clase es instanciada
 * y ejecutada cuando el servidor inicia y es responsable de todos los procesos de inicialización.
 * @author hjiron. 06-12-2004
 * @version 1.0
 */
public class SbeInitPlugin implements PlugIn {
	
	static Logger logger = Logger.getLogger(SbeInitPlugin.class);
	/** Identificador para las reglas de parseo del archivo de inicialización del InitPlugin. */
	public static final String INIT_PLUGIN_XML_KEY = "InitPlugin"; //$NON-NLS-1$
	/** Nombre del método para obtener instancias de singleton. */
	private static final String SINGLETON_METHOD = "getInstance"; //$NON-NLS-1$
	/** Mensaje que indica que la aplicación se está inicializando. */
	private static final String INIT_START_MESSAGE = ": initializing...."; //$NON-NLS-1$
	/** Mensaje que indica que un módulo no se ha inicializado correctamente. */
	private static final String INIT_ERROR_MESSAGE = " not initialized."; //$NON-NLS-1$
	/** Mensaje que indica que un módulo se ha inicializado correctamente. */
	private static final String INIT_SUCCESS_MESSAGE = " initialized."; //$NON-NLS-1$
	/** Mensaje que indica que la configuración de inicialización no se encontró. */
	private static final String INIT_CONFIG_ERROR_MESSAGE = ": init configuration not found."; //$NON-NLS-1$
	/** Llave que sirve para obtener el parámetro de properties.*/
	private static final String PROPERTIES_PARAMETER_KEY = "propertiesKey"; //$NON-NLS-1$
	/** La llave que identifica un archivo de properties. */
	private String propertiesKey = null;
	/**
	 * Ejecuta los procesos de inicialización.
	 * @param actionServlet el <code>Servlet</code> que invocó la inicialización.
	 * @param moduleConfig configuración pasada por el <code>Servlet</code>.
	 */
	public void init(ActionServlet actionServlet, ModuleConfig moduleConfig) {
		
		ServletContext context = actionServlet.getServletContext();
		IPathConverter pathConverter = new PathConverter();
		// se inicializan las clases de conversión de paths y parseo de XML.
		Map initProperties = (moduleConfig.findPlugInConfigs()[0]).getProperties();
		Collection xmlInit = new ArrayList();
		File initFile = null;
		String initPath = null;
		XMLBaseDAO xmlDao = new XMLBaseDAO();
		InitPluginBean initConfig = null;
		pathConverter.init(context);
		// Inicializacion de Log4j
		Log4JInit logInit = new Log4JInit();
		try {
			logInit.init(pathConverter.getAbsolutePath((String) initProperties.get("initLog4j")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		logger.info(this.getClass().getName() + INIT_START_MESSAGE);
		
		initPath = pathConverter.getAbsolutePath((String) initProperties.get("initFile")); //$NON-NLS-1$
		// Lista de inicialización para el XmlDao.
		initFile = new File(initPath);
		
		System.out.println(initFile.getAbsolutePath());
		
		xmlInit.add(pathConverter.getAbsolutePath((String) initProperties.get("initArrayRuleFile"))); //$NON-NLS-1$
		xmlInit.add(pathConverter.getAbsolutePath((String) initProperties.get("initRulesFile"))); //$NON-NLS-1$
		xmlInit.add(pathConverter);
		xmlDao.init(xmlInit);
		initConfig = (InitPluginBean) XMLBaseDAO.parse(INIT_PLUGIN_XML_KEY, initFile);
		//Registra los convertidores necesarios para el parseo de archivos XML.
		if (initConfig != null) {
			InitParameterMapBean initParams = initConfig.getInitParameters();
			InitModuleBean module = null;
			String parseKey = null;
			String className = null;
			IInitializer initializer = null;
			File configFile = null;
			Object parsed = null;
			// inicialización de los parámetros del InitPlugin.
			initializeParameters(initParams);
			// inicialización de los módulos de inicialización.
			for (int i = 0; i < initConfig.getModuleCount(); i++) {
				initializer = null;
				parsed = null;
				module = initConfig.getModule(i);
				try {
					parseKey = module.getConfigRulesKey();
					className = module.getConfigClass();
					if (parseKey != null) {
						if (parseKey.equals(propertiesKey)) {
							// parsea un archivo de properties.
							configFile = new File(pathConverter.getAbsolutePath(module.getConfigFile()));
							parsed = PropertiesBaseDAO.parse(configFile);
						}
						else if (parseKey.trim().length() != 0) {
							// parsea un archivo XML.
							configFile = new File(pathConverter.getAbsolutePath(module.getConfigFile()));
							parsed = XMLBaseDAO.parse(module.getConfigRulesKey(), configFile);
						}
					}
					if (!GenericValidator.isBlankOrNull(className)) {
						// instancia la clase de inicialización.
						if (module.isSingleton()) {
							Method method = Class.forName(className).getMethod(SINGLETON_METHOD, new Class[0]);
							initializer = (IInitializer) method.invoke(null, new Object[0]);
						}
						else {
							initializer = (IInitializer) Class.forName(module.getConfigClass()).newInstance();
						}
						// invoca el método de inicialización.
						initializer.init(parsed);
						// registra el MBean.
					}
					logger.info(className + INIT_SUCCESS_MESSAGE);
				}
				catch (InitException ie) {
					logger.error(className + INIT_ERROR_MESSAGE);
				}
				catch (NoSuchMethodException nsme) {
					logger.error(className + INIT_ERROR_MESSAGE);
				}
				catch (InvocationTargetException ite) {
					logger.error(className + INIT_ERROR_MESSAGE);
				}
				catch (InstantiationException ie) {
					logger.error(className + INIT_ERROR_MESSAGE);
				}
				catch (ClassNotFoundException cnfe) {
					logger.error(className + INIT_ERROR_MESSAGE);
				}
				catch (IllegalAccessException iae) {
					logger.error(className + INIT_ERROR_MESSAGE);
				}
			}
		}
		else {
			logger.error(SbeInitPlugin.class.getName() + INIT_CONFIG_ERROR_MESSAGE);
		}
		
	}
	/* (no Javadoc)
	 * @see org.apache.struts.action.PlugIn#destroy()
	 */
	public void destroy() {
	}
	/**
	 * Inicializa los parámetros para esta clase.
	 * @param parameters parámetros de inicialización.
	 */
	private void initializeParameters(InitParameterMapBean parameters) {
		this.propertiesKey = parameters.getValue(PROPERTIES_PARAMETER_KEY);
	}
}