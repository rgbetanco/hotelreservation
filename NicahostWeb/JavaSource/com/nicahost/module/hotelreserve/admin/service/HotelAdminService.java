/*
 * Created on Jul 9, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.service;

import java.util.ArrayList;
import java.util.Collection;

import com.nicahost.module.hotelreserve.admin.dao.HotelAdminDAO;
import com.nicahost.module.hotelreserve.admin.dto.RoomsTableDTO;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelAdminService {

	private static HotelAdminService hotelAdminService = null;
	private static HotelAdminDAO daoHotelAdmin = new HotelAdminDAO();

	public static HotelAdminService getInstance() {
		if (hotelAdminService == null) {
			hotelAdminService = new HotelAdminService();
		}
		return hotelAdminService;
	}
	
	public void updateRooms(ArrayList roomsToUpdate) throws Exception{
		daoHotelAdmin.updateRoomsTable(roomsToUpdate);
	}
	
	public void insertRooms(RoomsTableDTO roomsToInsert) throws Exception{
		daoHotelAdmin.insertRoomsTable(roomsToInsert);
	}

	public void commitChanges(ArrayList anulled, ArrayList confirmed, String userParm)
		throws Exception {

		daoHotelAdmin.updateConfirmations(confirmed, userParm);
		daoHotelAdmin.updateAnnullment(anulled, userParm);

	}
	public Collection getReservation() throws Exception {
		Collection result;
		HotelAdminDAO dao = new HotelAdminDAO();
		result = dao.getRoomReservations();
		return result;
	}
	public Collection getConfirmedAnulled(long initDate, long finDate) throws Exception {
			Collection result;
			HotelAdminDAO dao = new HotelAdminDAO();
			result = dao.getConfirmedAnulled(initDate, finDate);
			return result;
		}
	public Collection getRooms() throws Exception{
		Collection result;
		HotelAdminDAO dao = new HotelAdminDAO();
		result = dao.getRooms();
		return result;
	}

	public Collection getHistory() throws Exception {
		Collection result;
		result = daoHotelAdmin.getHistory();
		return result;
	}
	
	public boolean getAccessibility(String loginParm, String passParm) throws Exception {
		boolean result;
		result = daoHotelAdmin.grantDenyAccess(loginParm, passParm);
		return result;
	}

}
