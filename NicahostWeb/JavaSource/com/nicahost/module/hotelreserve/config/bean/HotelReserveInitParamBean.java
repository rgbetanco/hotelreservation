/*
 * Created on Jul 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.config.bean;

import java.io.Serializable;

import com.nicahost.common.config.bean.InitParameterArrayBean;
import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.exception.InitException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelReserveInitParamBean implements IInitializer, Serializable {
	private static final String INIT_OBJECT_ERROR = "Init object not an instance of "; //$NON-NLS-1$

	private static HotelReserveInitParamBean initParametersBean = null;
	public static final String MARCHANTID = "MarchantId";
	public static final String TERMINALID = "TerminalId";
	public static final String REALPAY_DAT = "RealPayCGIDAT";
	public static final String DEFAULT_NIGHTS = "DefaultNights";
	
	private InitParameterMapBean list;
	
	/**
	 * 
	 */
	private HotelReserveInitParamBean() {

	}
	
	public static HotelReserveInitParamBean getInstance() {
		if (initParametersBean == null ) {
			initParametersBean = new HotelReserveInitParamBean();
		}
		
		return initParametersBean;
	}
	

	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IInitializer#init(java.lang.Object)
	 */
	public void init(Object o) throws InitException {
		if (o instanceof InitParameterMapBean) {
			this.list = (InitParameterMapBean) o;
		} else {
			InitException initException = new InitException(INIT_OBJECT_ERROR +
															InitParameterArrayBean.class.getName());
			
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

}
