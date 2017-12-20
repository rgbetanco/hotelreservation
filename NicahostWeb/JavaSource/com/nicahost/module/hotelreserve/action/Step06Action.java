/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.util.Calendar;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.dto.ReserveDTO;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.service.HotelReserveMailService;
import com.nicahost.module.hotelreserve.service.HotelReserveService;
import com.nicahost.module.hotelreserve.view.ConfirmView;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step06Action extends BaseAction {

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
		navigationItems.addElement(new NavigationItem("label.nav5", null));
		headerForm.setNavigationItems(navigationItems);	

//		Invocacion de servicio		
		HotelReserveService hotelService = HotelReserveService.getInstance();
		HotelReserveMailService mailService = HotelReserveMailService.getInstance();
		
		ReserveForm reserveForm = (ReserveForm) form;
		ReserveDTO reserveDTO = new ReserveDTO();
		
		BeanUtils.copyProperties(reserveDTO,reserveForm);
		
		ConfirmView confirmView = hotelService.processReservation(reserveDTO);
		
		String code = confirmView.getConfirmationCode();
		if (code != null && !code.trim().equals("")) {
			StringBuffer fullName = new StringBuffer();
			fullName.append(confirmView.getFirstName()).append(" ").append(confirmView.getLastName());
			String userEmail = confirmView.getEmail();			
			mailService.sendConfirmationNoticeToUser(userEmail,fullName.toString(),code,getLocale(request));
		}
		
		Calendar initDateCal = ((ReserveForm) form).getInitDateCal();
		Calendar endDateCal = ((ReserveForm) form).getEndDateCal();
		String roomTypeId = ((ReserveForm) form).getRoomTypeId();		
		String numNights = hotelService.daysDiff(initDateCal,endDateCal);
		String roomTypeName = hotelService.getRoomTypeName(roomTypeId);
				
//		Guardar objetos en request	
		request.setAttribute("confirmView", confirmView);
		request.setAttribute("numNights",numNights);		
		request.setAttribute("roomTypeName",roomTypeName);					
	
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
