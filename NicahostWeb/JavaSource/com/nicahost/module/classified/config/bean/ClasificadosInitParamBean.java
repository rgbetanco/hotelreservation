/*
 * Created on Jan 16, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.config.bean;

import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.exception.InitException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClasificadosInitParamBean implements IInitializer {
	/** Mensaje de error cuando se recibe un objeto de inicialización incorrecto. */
	private static final String INIT_OBJECT_ERROR = "Init object not an instance of "; //$NON-NLS-1$
	/** Instancia singleton **/
	private static ClasificadosInitParamBean initParamBean = null;
	/** Mapa de parámetros. */
	private InitParameterMapBean list;
	
	public static final String TEMP_IMG = "tempimg";
	public static final String MAX_HITS = "maxHits"; 	
	
	private ClasificadosInitParamBean() {/* Empty constructor */}
	
	public static ClasificadosInitParamBean getInstance() {
		if (initParamBean == null) {
			initParamBean = new ClasificadosInitParamBean();
		}
		
		return initParamBean;
	}
	
	
	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IInitializer#init(java.lang.Object)
	 */
	public void init(Object o) throws InitException {
		if (o instanceof InitParameterMapBean) {
			this.list = (InitParameterMapBean) o;
		} else {
			InitException initException = new InitException(INIT_OBJECT_ERROR +
															InitParameterMapBean.class.getName());
			throw initException;
		}
	}

	/**
	 * @return
	 */
	public InitParameterMapBean getList() {
		return list;
	}

	/**
	 * @param bean
	 */
	public void setList(InitParameterMapBean bean) {
		list = bean;
	}
	
	public void setValue(String name, String value) {
		this.getList().addParameter(name, value);
	}
	
	public String getValue(String name) {
		return this.getList().getValue(name);
	}

}
