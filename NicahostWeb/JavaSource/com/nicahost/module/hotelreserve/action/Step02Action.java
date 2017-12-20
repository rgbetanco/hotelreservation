/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.dto.RoomDTO;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.helper.ReserveSession;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step02Action extends BaseAction {

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
		//inicializacion de objetos session
		HttpSession httpSession = null;
		ReserveSession reserveSession = null;			
		httpSession = request.getSession();
		reserveSession = (ReserveSession) httpSession.getAttribute("reserveSession");
		
		//Vector de navegacion	
		Vector navigationItems = new Vector();
		navigationItems.addElement(new NavigationItem("label.nav1", "/hotelreserve/reserve.do"));
		navigationItems.addElement(new NavigationItem("label.nav2", "/hotelreserve/step01.do"));
		navigationItems.addElement(new NavigationItem("label.nav3", null));
		headerForm.setNavigationItems(navigationItems);		

		//Recuperacion de datos del request
		String roomTypeId = request.getParameter("roomTypeId");
		String initDate = request.getParameter("initDate");
		String endDate = request.getParameter("endDate");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", getLocale(request));
		Calendar initDateCal = new GregorianCalendar();
		Calendar endDateCal = new GregorianCalendar();
		initDateCal.setTime(dateFormat.parse(initDate));
		endDateCal.setTime(dateFormat.parse(endDate));

		//Recuperacion de datos del session
		Map roomAvailability = (Map) reserveSession.getRoomAvailability();
		String[] selectedIdRooms = ((ReserveForm) form).getSelectedIdRooms();
		
		//Invocacion de servicio
		HotelReserveService service = HotelReserveService.getInstance();
		String numNights = service.daysDiff(initDateCal,endDateCal);
		String roomTypeName = service.getRoomTypeName(roomTypeId);		
		Collection countries = service.getCountry();
		//<--Collection ethnicities = service.getEthnicity();-->

		RoomDTO dto;
		ArrayList checkedRooms = new ArrayList();
		for (int i = 0; i < selectedIdRooms.length; i++) {
			String roomId = selectedIdRooms[i];
			dto = (RoomDTO) roomAvailability.get(roomId);
			checkedRooms.add(dto);			
		}
		
		/*RoomDTO dto;
		String checkBoxId;
		ArrayList checkedRooms = new ArrayList();
		for (Iterator iter = roomAvailability.iterator(); iter.hasNext();) {
			dto = (RoomDTO) iter.next();
			checkBoxId = request.getParameter("roomId"+dto.getId());
			if (null != checkBoxId && checkBoxId.equalsIgnoreCase("on")) {
				checkedRooms.add(dto);
			}
		}*/
		
		//Guardar objetos en el form (tipo session)
		((ReserveForm) form).setSelectedRooms(checkedRooms);
		((ReserveForm) form).setInitDateCal(initDateCal);
		((ReserveForm) form).setEndDateCal(endDateCal);
		((ReserveForm) form).setRoomTypeId(roomTypeId);
						
		//Guardar objetos en request	
		request.setAttribute("initDate",initDate);
		request.setAttribute("endDate",endDate);	
		request.setAttribute("roomTypeId",roomTypeId);
		request.setAttribute("numNights",numNights);		
		request.setAttribute("roomTypeName",roomTypeName);		
		request.setAttribute("countries", countries);
		//<--request.setAttribute("ethnicities", ethnicities);-->


		//session.removeAttribute("roomAvailability");
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);

		return forward;
	}

}
