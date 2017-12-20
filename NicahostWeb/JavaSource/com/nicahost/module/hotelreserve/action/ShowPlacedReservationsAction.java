/*
 * Created on Jul 23, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.form.LoginForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;
import com.nicahost.module.hotelreserve.view.PlacedReservationView;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowPlacedReservationsAction extends BaseAction {

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
		
//		Recuperacion de datos del request
		LoginForm loginForm = (LoginForm) form;
		String email = loginForm.getUser();
		String code = loginForm.getPass();

//		Invocacion de servicio
		HotelReserveService service = HotelReserveService.getInstance();
		Collection placedReservations = service.getPlacedReservation(email,code);
		Calendar initDateCal = null;
		Calendar endDateCal = null;
		String numNights = null;
		String roomTypeName = null;
		String guest = null;
		String firstName = null;
		String lastName = null;
		String status = null;
		
		for (Iterator iter = placedReservations.iterator(); iter.hasNext();) {
			PlacedReservationView element = (PlacedReservationView) iter.next();
			initDateCal = element.getCheckInDate();
			endDateCal = element.getCheckOutDate();
			numNights = element.getNumNights();
			roomTypeName = element.getRoomTypeName();
			//guest = element.getGuest();
			firstName = element.getFirstName();
			lastName = element.getLastName();
			status = element.getStatus();
		}
		
		
//		Guardar objetos en request
		request.setAttribute("email",email);
		request.setAttribute("code",code);
		request.setAttribute("initDateCal",initDateCal);
		request.setAttribute("endDateCal",endDateCal);
		request.setAttribute("numNights",numNights);
		request.setAttribute("roomTypeName",roomTypeName);
		//request.setAttribute("guest",guest);
		request.setAttribute("placedReservations",placedReservations);
		request.setAttribute("firstName",firstName);
		request.setAttribute("lastName",lastName);
		request.setAttribute("status",status);
		
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);	
		
		return forward;
	}

}
