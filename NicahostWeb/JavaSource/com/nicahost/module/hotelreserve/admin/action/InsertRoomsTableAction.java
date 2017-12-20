/*
 * Created on Jul 22, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.dto.RoomsTableDTO;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author rgbetanco
 *
 * This methos will be use to insert the data of a new room into the rooms table
 * It will create a DTO that will be pass on to the DAO for execution.
 */
public class InsertRoomsTableAction extends AdminBaseAction {

	private HotelAdminService adminService = HotelAdminService.getInstance();
	private HotelReserveService service1 = HotelReserveService.getInstance();

	public ActionForward adminExecuteAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;

		String idRoomToInsert = request.getParameter("idRoomToInsert");
		String roomTypeToInsert = request.getParameter("roomTypeToInsert");
		String maxPeople = request.getParameter("maxPeopleToInsert");
		String description = request.getParameter("descriptionToInsert");
		String price = request.getParameter("priceToInsert");
		String blocked = request.getParameter("blockedToInsert");

		RoomsTableDTO dto = new RoomsTableDTO();

		dto.setRoomId(Integer.parseInt(idRoomToInsert));
		dto.setRoomType(Integer.parseInt(roomTypeToInsert));
		dto.setMaxPeople(Integer.parseInt(maxPeople));
		dto.setDescription(description);
		dto.setPrice(Double.parseDouble(price));
		dto.setBlocked(blocked);

		adminService.insertRooms(dto);

		Collection roomsToShow = adminService.getRooms();
		Collection roomTypes = service1.getRoomTypes();

		request.setAttribute("rooms", roomsToShow);
		request.setAttribute("roomTypes", roomTypes);

		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		return forward;

	}

}
