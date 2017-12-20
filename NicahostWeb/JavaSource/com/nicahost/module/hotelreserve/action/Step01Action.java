/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.nicahost.module.hotelreserve.form.Step01Form;
import com.nicahost.module.hotelreserve.helper.ReserveSession;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step01Action extends BaseAction {

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
			navigationItems.addElement(new NavigationItem("label.nav2", null));
			headerForm.setNavigationItems(navigationItems);		

			//Recuperacion de datos del request
			Step01Form step01Form = (Step01Form) form;
			String adult = step01Form.getAdult();
			String child = step01Form.getChild();
			
			String roomTypeId = step01Form.getRoomTypeId();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", getLocale(request));
			Calendar initDateCal = new GregorianCalendar();
			Calendar endDateCal = new GregorianCalendar();

			initDateCal.setTime(dateFormat.parse(step01Form.getInitDate()));
			endDateCal.setTime(dateFormat.parse(step01Form.getEndDate()));

			//Invocacion de servicio
			HotelReserveService service = HotelReserveService.getInstance();		
			String numNights = service.daysDiff(initDateCal,endDateCal);
			String roomTypeName = service.getRoomTypeName(roomTypeId);			
			Map roomAvailabilityMap = service.getAvailableRooms(roomTypeId, initDateCal, endDateCal);
			Collection roomAvailability = roomAvailabilityMap.values();
			
			//Guardar objetos en session
			reserveSession.setRoomAvailability(roomAvailabilityMap);

			//Guardar objetos en request
			request.setAttribute("adult",adult);
			request.setAttribute("child",child);
			request.setAttribute("initDateCal",initDateCal);
			request.setAttribute("endDateCal",endDateCal);
			request.setAttribute("initDate",step01Form.getInitDate());
			request.setAttribute("endDate",step01Form.getEndDate());			
			request.setAttribute("numNights",numNights);
			request.setAttribute("roomTypeId",roomTypeId);
			request.setAttribute("roomTypeName",roomTypeName);
			request.setAttribute("roomAvailability",roomAvailability);
						
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
