/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.util.Calendar;
import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.framework.common.service.CommonService;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step04Action extends BaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;
		
		//Vector de navegacion	
		Vector navigationItems = new Vector();
		navigationItems.addElement(new NavigationItem("label.nav1", "/hotelreserve/reserve.do"));
		navigationItems.addElement(new NavigationItem("label.nav2", "/hotelreserve/step01.do"));
		navigationItems.addElement(new NavigationItem("label.nav3", "/hotelreserve/step02.do"));
		navigationItems.addElement(new NavigationItem("label.nav4", null));
		headerForm.setNavigationItems(navigationItems);		

//		Invocacion de servicio		
		HotelReserveService hotelService = HotelReserveService.getInstance();		
		Calendar initDateCal = ((ReserveForm) form).getInitDateCal();
		Calendar endDateCal = ((ReserveForm) form).getEndDateCal();
		String roomTypeId = ((ReserveForm) form).getRoomTypeId();		
		String numNights = hotelService.daysDiff(initDateCal,endDateCal);
		String roomTypeName = hotelService.getRoomTypeName(roomTypeId);
		CommonService service = CommonService.getInstance();			
		Collection cardMonths = service.getMonths();
		Collection cardYears = service.getCardExpirationYears();
		Collection cardTypes = service.getCardTypes();
		
//		Guardar objetos en request	
		request.setAttribute("numNights",numNights);		
		request.setAttribute("roomTypeName",roomTypeName);	
		request.setAttribute("cardMonths",cardMonths);
		request.setAttribute("cardYears",cardYears);
		request.setAttribute("cardTypes",cardTypes);
				
	
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
