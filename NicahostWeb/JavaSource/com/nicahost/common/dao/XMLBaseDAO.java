package com.nicahost.common.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.nicahost.common.config.bean.InitParameterArrayBean;
import com.nicahost.common.config.bean.InitParameterBean;
import com.nicahost.common.exception.InitException;
import com.nicahost.common.exception.SbeException;
import com.nicahost.common.util.IPathConverter;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.commons.digester.xmlrules.XmlLoadException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 * Permite parsear datos en formato XML utilizando una serie de conjuntos de reglas
 * que tiene almacenados. 
 * @author hjiron.
 * @version 1.0 
 * Fecha: 30-11-2004
 */
public class XMLBaseDAO implements IBaseDAO {
	/** Mensaje de error cuando no se encuentra el digester asociado a una llave. */
	private static final String DIGESTER_NOT_FOUND_ERROR = "Unable to find digester for key: "; //$NON-NLS-1$
	/** Mapa con los conjuntos de reglas disponibles. */
	private static Map ruleSets = null;
	/** Llave temporal que se utiliza durante la inicialización. */
	private static final String TEMPORARY_KEY = "_TEMP"; //$NON-NLS-1$
	/**
	 * Agrega un conjunto de reglas al mapa.
	 * @param key el identificador que se le asociará al conjunto de reglas.
	 * @param path el path absoluto del archivo de reglas.
	 * @return <code>true</code> si el conjunto de reglas fue agregado.
	 */
	public static boolean addRuleSet(String key, String path) {
		boolean validKey = !ruleSets.containsKey(key);
		if (validKey) {
			File ruleFile = new File(path);
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = null;
			String line;
			try {
				reader = new BufferedReader(new FileReader(ruleFile));
				// lee el contenido del archivo de reglas y lo agrega al buffer.
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				// guarda el contenido de las reglas.
				ruleSets.put(key, buffer.toString());
			}
			catch (FileNotFoundException fnfe) {
				SbeException sbeException = new SbeException(fnfe);
			}
			catch (IOException ioe) {
				SbeException sbeException = new SbeException(ioe);
			}
			finally {
				if (reader != null) {
					try {
						reader.close();
					}
					catch (IOException ioe) {
						SbeException sbeException = new SbeException(ioe);
					}
				}
			}
		}
		return validKey;
	}
	/**
	 * Parsea el <code>File</code> usando el set de reglas determinado por el key.
	 * @param key la llave que determina el conjunto de reglas que se desea usar.
	 * @param file el <code>File</code> que se debe parsear.
	 * @return <code>Object</codes> que contiene los resultados del parseo.
	 */
	public static Object parse(String key, File file) {
		return parse(key, (Object) file);
	}
	/**
	 * Parsea el <code>InputSource</code> usando el set de reglas determinado por el key.
	 * @param key la llave que determina el conjunto de reglas que se desea usar.
	 * @param is el <code>InputSource</code> que se debe parsear.
	 * @return <code>Object</codes> que contiene los resultados del parseo.
	 */
	public static Object parse(String key, InputSource is) {
		return parse(key, (Object) is);
	}
	/**
	 * Parsea el <code>InputStream</code> usando el set de reglas determinado por el key.
	 * @param key la llave que determina el conjunto de reglas que se desea usar.
	 * @param is el <code>InputStream</code> que se debe parsear.
	 * @return <code>Object</codes> que contiene los resultados del parseo.
	 */
	public static Object parse(String key, InputStream is) {
		return parse(key, (Object) is);
	}
	/**
	 * Parsea el <code>Object</code> usando el set de reglas determinado por el key.
	 * @param key la llave que determina el conjunto de reglas que se desea usar.
	 * @param obj el <code>Object</code> que se debe parsear.
	 * @return <code>Object</codes> que contiene los resultados del parseo.
	 */
	private static Object parse(String key, Object obj) {
		Object result = null;
		Digester digester = null;
		InputSource source = null;
		String ruleSet = null;
		try {
			if (ruleSets.containsKey(key)) {
				ruleSet = (String) ruleSets.get(key);
				source = new InputSource(new StringReader(ruleSet));
				// produce un nuevo Digester con el set de reglas.
				digester = DigesterLoader.createDigester(source);
				if (digester != null) {
					if (obj instanceof File) {
						result = digester.parse((File) obj);
					}
					else if (obj instanceof InputStream) {
						result = digester.parse((InputStream) obj);
					}
					else if (obj instanceof InputSource) {
						result = digester.parse((InputSource) obj);
					}
					else if (obj instanceof Reader) {
						result = digester.parse((Reader) obj);
					}
				}
				else {
					SbeException sbeException = new SbeException(DIGESTER_NOT_FOUND_ERROR.concat(key));
				}
			}
			else {
				SbeException sbeException = new SbeException(DIGESTER_NOT_FOUND_ERROR.concat(key));
			}
		}
		catch (XmlLoadException xle) {
			SbeException sbeException = new SbeException(xle);
		}
		catch (IOException ioe) {
			SbeException sbeException = new SbeException(ioe);
		}
		catch (SAXException se) {
			SbeException sbeException = new SbeException(se);
		}
		return result;
	}
	/**
	 * Parsea el <code>Reader</code> usando el set de reglas determinado por el key.
	 * @param key la llave que determina el conjunto de reglas que se desea usar.
	 * @param reader el <code>Reader</code> que se debe parsear.
	 * @return <code>Object</codes> que contiene los resultados del parseo.
	 */
	public static Object parse(String key, Reader reader) {
		return parse(key, (Object) reader);
	}
	/**
	 * Elimina un conjunto de reglas del mapa
	 * @param key el identificador del conjunto de reglas a remover.
	 */
	public static void removeRuleSet(String key) {
		ruleSets.remove(key);
	}
	/**
	 * Constructor por defecto.
	 */
	public XMLBaseDAO() {
	}
	/* (non-Javadoc)
	 * @see net.bac.sbe.web.common.dao.IBaseDAO#destroy()
	 */
	public void destroy() {
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	protected void finalize() throws Throwable {
		super.finalize();
		destroy();
	}
	/**
	 * Inicializa el objeto con sus propiedades de inicialización.
	 * @param properties <code>Object</code> que contiene las propiedades de inicialización.
	 */
	public void init(Object properties) {
		try {
			ArrayList props = (ArrayList) properties;
			String initRuleFilePath = (String) props.get(0);
			File rulesFile = new File((String) props.get(1));
			String tempKey = TEMPORARY_KEY;
			InitParameterArrayBean initParams;
			InitParameterBean param;
			IPathConverter converter = (IPathConverter) props.get(2);
			ruleSets = new HashMap();
			addRuleSet(tempKey, initRuleFilePath);
			initParams = (InitParameterArrayBean) parse(tempKey, rulesFile);
			removeRuleSet(tempKey);
			// load rule files.
			for (int i = 0; i < initParams.size(); i++) {
				param = initParams.getParameter(i);
				addRuleSet(param.getName(), converter.getAbsolutePath(param.getValue()));
			}
		}
		catch (Exception e) {
			InitException initException = new InitException(e);
		}
	}
}
