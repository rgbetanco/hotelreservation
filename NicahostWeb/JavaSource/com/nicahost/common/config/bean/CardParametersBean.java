/*
 * Created on Jul 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.bean;

import java.io.Serializable;

import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.exception.InitException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CardParametersBean implements IInitializer, Serializable {
	private static final String INIT_OBJECT_ERROR = "Init object not an instance of "; //$NON-NLS-1$

	private static CardParametersBean cardParametersBean = null;
	
	private InitParameterArrayBean list;
	
	/**
	 * 
	 */
	private CardParametersBean() {

	}
	
	public static CardParametersBean getInstance() {
		if (cardParametersBean == null ) {
			cardParametersBean = new CardParametersBean();
		}
		
		return cardParametersBean;
	}
	

	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IInitializer#init(java.lang.Object)
	 */
	public void init(Object o) throws InitException {
		if (o instanceof InitParameterArrayBean) {
			this.list = (InitParameterArrayBean) o;
		} else {
			InitException initException = new InitException(INIT_OBJECT_ERROR +
															InitParameterArrayBean.class.getName());
			
			throw initException;
		}		

	}

	/**
	 * @return
	 */
	public InitParameterArrayBean getList() {
		return list;
	}

	/**
	 * @param bean
	 */
	public void setList(InitParameterArrayBean bean) {
		list = bean;
	}

}
