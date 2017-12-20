/*
 * Created on Jul 22, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.ArrayList;
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
 * This methos should update the rooms table in the database
 * it will read the data from the request pass it to an array of DTOs and then to the DAO
 */
public class UpdateRoomsTableAction extends AdminBaseAction {

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

		String[] idRoomLocal = request.getParameterValues("idRoom");
		String[] roomTypeLocal = request.getParameterValues("roomType");
		String[] maxPeopleLocal = request.getParameterValues("maxPeople");
		String[] descriptionLocal = request.getParameterValues("description");
		String[] priceLocal = request.getParameterValues("price");
		String[] blockedLocal = request.getParameterValues("blocked");
		ArrayList rooms = new ArrayList();
		for (int i = 0; i < idRoomLocal.length; i++) {
			RoomsTableDTO dto = new RoomsTableDTO();
			dto.setRoomId(Integer.parseInt(idRoomLocal[i]));
			dto.setRoomType(Integer.parseInt(roomTypeLocal[i]));
			dto.setMaxPeople(Integer.parseInt(maxPeopleLocal[i]));
			dto.setDescription(descriptionLocal[i]);
			dto.setPrice(Double.parseDouble(priceLocal[i]));
			dto.setBlocked(blockedLocal[i]);
			rooms.add(dto);
		}

		adminService.updateRooms(rooms);
		Collection roomsToShow = adminService.getRooms();
		Collection roomTypes = service1.getRoomTypes();

		request.setAttribute("rooms", roomsToShow);
		request.setAttribute("roomTypes", roomTypes);

		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);

		return forward;

	}

}
