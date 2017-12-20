/*
 * Created on Jan 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.config.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.exception.InitException;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelReserveInitMailBean implements IInitializer, Serializable {
	public static final String EMAIL_FROM = "from";
	public static final String EMAIL_ADMIN_KEY = "Administradores";
	public static final String EMAIL_OPERA_KEY = "Operadores";	
	private static final String INIT_OBJECT_ERROR = "Init object not an instance of "; //$NON-NLS-1$	
	
	private static HotelReserveInitMailBean hotelReserveInitMailBean = null;	
	private Map mailingList;
	
	private HotelReserveInitMailBean() {/* Empty constructor*/ }
	
	
	public static HotelReserveInitMailBean getInstance() {
		if (hotelReserveInitMailBean == null) {
			hotelReserveInitMailBean = new HotelReserveInitMailBean();			
		}
		
		return hotelReserveInitMailBean;
	}
	
	
	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IInitializer#init(java.lang.Object)
	 */
	public void init(Object o) throws InitException {
		if (o instanceof Map) {
			this.mailingList = (Map) o;	
		} else {
			InitException initException = new InitException(INIT_OBJECT_ERROR +
														HotelReserveInitMailBean.class.getName());
			
			throw initException;			
		}

	}
	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList getMailingList(String name) {
		ArrayList result = null;
		if (mailingList.containsKey(name)) {
			if (mailingList.get(name) instanceof ArrayList)
				result = (ArrayList) mailingList.get(name);
		}
		
		return result;
	}	
	

	public String getFrom() {
		
		return (String) mailingList.get(EMAIL_FROM);
	}

	public String getValue(String key) {
		return (String) mailingList.get(key);
	}
}
