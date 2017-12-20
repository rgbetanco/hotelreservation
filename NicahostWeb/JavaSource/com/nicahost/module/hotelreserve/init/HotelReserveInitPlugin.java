/*
 * Created on Jan 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.init;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitParamDAO;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelReserveInitPlugin implements PlugIn {

/* (non-Javadoc)
 * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
 */
public void init(ActionServlet arg0, ModuleConfig arg1)
	throws ServletException {
	
	//Inicializa los parametros desde las tablas
	HotelReserveInitParamDAO.getInstance();

}


/* (non-Javadoc)
 * @see org.apache.struts.action.PlugIn#destroy()
 */
public void destroy() {
	// TODO Auto-generated method stub

}


}
