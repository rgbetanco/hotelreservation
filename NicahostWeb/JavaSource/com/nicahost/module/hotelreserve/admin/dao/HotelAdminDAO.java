/*
 * Created on Jul 7, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.module.hotelreserve.admin.dto.AnnulledDTO;
import com.nicahost.module.hotelreserve.admin.dto.ConfirmedDTO;
import com.nicahost.module.hotelreserve.admin.dto.RoomsTableDTO;
import com.nicahost.module.hotelreserve.view.HistoryView;
import com.nicahost.module.hotelreserve.view.ReservationView;
import com.nicahost.module.hotelreserve.view.RoomView;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelAdminDAO extends DBBaseDAO {

	private static final String DBASEKEY = "dsHotel";
	private static final String RESERVATIONPERITEM_SQL =
		"SELECT * FROM roomreservation WHERE id = ?";
	private static final String RESERVATION_SQL =
		//	  1			2		3			4					5			6
	"SELECT a.id, a.roomid, a.email, a.reservationDate, a.checkinDate, a.checkoutdate, "
		//			7		8		 9		   10		   11			12	  
	+"a.guest, a.status, a.total, b.firstName, b.lastName, a.comment FROM roomreservation a, clientes b WHERE a.email = b.email and a.status = 2 ORDER BY a.reservationDate desc";
	private static final String CONFIRMEDANULLED_SQL =
		//	  1			2		3			4					5			6
	"SELECT a.id, a.roomid, a.email, a.reservationDate, a.checkinDate, a.checkoutdate, "
		//			7		8		 9		   10		   11			12	  
	+"a.guest, a.status, a.total, b.firstName, b.lastName, a.comment FROM roomreservation a, clientes b "+
	"WHERE a.email = b.email and a.status <> 0 and a.checkindate >= ? and a.checkoutdate <= ? ORDER BY a.checkindate ASC";
	private static final String COPYTOHISTORY_SQL =
		"INSERT INTO roomreservationhist (id, roomid, email, reservationDate, checkindate, checkoutdate, guest,confirmed, anulled, total) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETERESERVATION_SQL =
		"DELETE FROM roomreservation WHERE id=?";
	private static final String HISTORY_SQL =
		//		  1			2		3			4				5					6		   
	"SELECT a.id, a.roomid, a.email, a.reservationDate, a.checkinDate, a.checkoutdate, "
		//     7		8		  9			10			11		   12	
	+"a.guest, a.status, a.total, b.firstname, b.lastname, a.comment FROM roomreservationhist a, clientes b WHERE a.email = b.email";
	private static final String UPDATERESERVATION_SQL =
		"UPDATE roomreservation SET status=?, statusdate = ?, approver=? WHERE id=?";
	private static final String LOGIN_SQL =
		"SELECT * FROM administrator WHERE login=? and password=?";

	private static final String UPDATEROOM_SQL =
		"UPDATE rooms SET roomid =?, roomType =?, maxpeople=?, briefdescription=?, pricepernight=?, blocked = ? WHERE roomid =?";
	
	private static final String INSERTROOM_SQL =
		"INSERT INTO rooms VALUES(?,?,?,?,?,?)";
	private static final String ROOMS_SQL = "SELECT * FROM rooms";

	public Collection getRooms() throws Exception {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			con = getPooledConnection(DBASEKEY);
			ps = con.prepareStatement(ROOMS_SQL);
			rs = ps.executeQuery();

			ArrayList rooms = new ArrayList();
			while (rs.next()) {
				RoomView roomsV = new RoomView();
				roomsV.setId(rs.getString(1));
				roomsV.setRoomType(Integer.toString(rs.getInt(2)));
				roomsV.setMaxPeople(rs.getString(3));
				roomsV.setDescription(rs.getString(4));
				roomsV.setPrice(rs.getString(5));
				roomsV.setBlocked(rs.getString(6));
				rooms.add(roomsV);
			}
	

			closeConnection(rs, ps, con);

		return rooms;
	}

	public void insertRoomsTable(RoomsTableDTO roomsTableDTO)
		throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		con = getPooledConnection(DBASEKEY);
		ps = con.prepareStatement(INSERTROOM_SQL);

		ps.setInt(1, roomsTableDTO.getRoomId());
		ps.setInt(2, roomsTableDTO.getRoomType());
		ps.setInt(3, roomsTableDTO.getMaxPeople());
		ps.setString(4, roomsTableDTO.getDescription());
		ps.setDouble(5, roomsTableDTO.getPrice());
		ps.setString(6, roomsTableDTO.getBlocked());

		ps.execute();
		
		closeConnection(ps, con);

	}

	public void updateRoomsTable(ArrayList roomsParm) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		con = getPooledConnection(DBASEKEY);
		ps = con.prepareStatement(UPDATEROOM_SQL);

		for (Iterator iter = roomsParm.iterator(); iter.hasNext();) {
			RoomsTableDTO roomsTableDTO = new RoomsTableDTO();
			roomsTableDTO = (RoomsTableDTO) iter.next();
			ps.setInt(1, roomsTableDTO.getRoomId());
			ps.setInt(2, roomsTableDTO.getRoomType());
			ps.setInt(3, roomsTableDTO.getMaxPeople());
			ps.setString(4, roomsTableDTO.getDescription());
			ps.setDouble(5, roomsTableDTO.getPrice());
			ps.setString(6, roomsTableDTO.getBlocked());
			ps.setInt(7, roomsTableDTO.getRoomId());

			ps.execute();
		}
		closeConnection(ps, con);
	}
	

	public boolean grantDenyAccess(String loginParm, String passParm)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = getPooledConnection(DBASEKEY);
		ps = con.prepareStatement(LOGIN_SQL);
		ps.setString(1, loginParm);
		ps.setString(2, passParm);

		rs = ps.executeQuery();
		int counter = 0;
		while (rs.next()) {
			counter += 1;
		}
		if (counter > 0) {
			closeConnection(rs, ps, con);
			return true;
		} else {
			closeConnection(rs, ps, con);
			return false;
		}
	}

	public Collection getRoomReservations() throws Exception {
		ArrayList result = new ArrayList();

		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			con = getPooledConnection(DBASEKEY);
			stm = con.prepareStatement(RESERVATION_SQL);
			rs = stm.executeQuery();

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			while (rs.next()) {
				ReservationView reserveView = new ReservationView();
				reserveView.setId(rs.getString(1));
				reserveView.setRoomNumV(rs.getString(2));
				reserveView.setEmailV(rs.getString(3));
				reserveView.setReservationDateV(
					df.format(new Date(rs.getLong(4))));
				reserveView.setCheckinDateV(df.format(new Date(rs.getLong(5))));
				reserveView.setCheckoutDateV(
					df.format(new Date(rs.getLong(6))));
				reserveView.setGuestV(rs.getString(7));
				reserveView.setStatusV(rs.getString(8));
				reserveView.setTotalV(rs.getString(9));
				reserveView.setFirstNameV(rs.getString(10));
				reserveView.setLastNameV(rs.getString(11));
				reserveView.setCommentV(rs.getString(12));
				result.add(reserveView);
			}

		} finally {
			closeConnection(rs, stm, con);
		}
		return result;
	}
	
	public Collection getConfirmedAnulled(long initDate, long finDate) throws Exception {
			ArrayList result = new ArrayList();

			Connection con = null;
			PreparedStatement stm = null;
			ResultSet rs = null;

			try {
				con = getPooledConnection(DBASEKEY);
				stm = con.prepareStatement(CONFIRMEDANULLED_SQL);
				stm.setLong(1, initDate);
				stm.setLong(2, finDate);
				
				rs = stm.executeQuery();

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

				while (rs.next()) {
					ReservationView reserveView = new ReservationView();
					reserveView.setId(rs.getString(1));
					reserveView.setRoomNumV(rs.getString(2));
					reserveView.setEmailV(rs.getString(3));
					reserveView.setReservationDateV(
						df.format(new Date(rs.getLong(4))));
					reserveView.setCheckinDateV(df.format(new Date(rs.getLong(5))));
					reserveView.setCheckoutDateV(
						df.format(new Date(rs.getLong(6))));
					reserveView.setGuestV(rs.getString(7));
					reserveView.setStatusV(rs.getString(8));
					reserveView.setTotalV(rs.getString(9));
					reserveView.setFirstNameV(rs.getString(10));
					reserveView.setLastNameV(rs.getString(11));
					reserveView.setCommentV(rs.getString(12));
					result.add(reserveView);
				}

			} finally {
				closeConnection(rs, stm, con);
			}
			return result;
		}


	public Collection getHistory() throws Exception {
		ArrayList result = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			con = getPooledConnection(DBASEKEY);
			ps = con.prepareStatement(HISTORY_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				HistoryView historyView = new HistoryView();
				historyView.setId(rs.getString(1));
				historyView.setRoomNumV(rs.getString(2));
				historyView.setEmailV(rs.getString(3));
				historyView.setReservationDateV(
					df.format(new Date(rs.getLong(4))));
				historyView.setCheckinDateV(df.format(new Date(rs.getLong(5))));
				historyView.setCheckoutDateV(
					df.format(new Date(rs.getLong(6))));
				historyView.setGuestV(rs.getString(7));
				historyView.setStatusV(rs.getString(8));
				historyView.setTotalV(rs.getString(9));
				historyView.setFirstNameV(rs.getString(10));
				historyView.setLastNameV(rs.getString(11));
				historyView.setCommentV(rs.getString(12));
				result.add(historyView);
			}
		} finally {
			closeConnection(rs, ps, con);
		}

		return result;
	}
	/**
	 * @param confirmedParm
	 * @param annulledDTO
	 * @throws Exception
	 * Este metodo debe de actualizar la informacion de la tabla de reservaciones 
	 * cambia es status de 2 a 1 siendo 1 == confirmado, 2==null, 0==anulado
	 */
	public void updateConfirmations(ArrayList confirmedParm, String userParm) throws Exception {

		Connection con0 = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		Date today = new Date();
		con0 = getPooledConnection(DBASEKEY);

		PreparedStatement ps0 = con0.prepareStatement(UPDATERESERVATION_SQL);

		for (Iterator iter = confirmedParm.iterator(); iter.hasNext();) {
			ConfirmedDTO element = (ConfirmedDTO) iter.next();
			ps0.setInt(1, 1);
			ps0.setString(2, sf.format(today));
			ps0.setString(3, userParm);
			
			ps0.setInt(4, element.getId());
			//Create the PDF file with the note to send by email
			CreatePDFConfirmNote createNote =
				new CreatePDFConfirmNote(element.getId());
			createNote.CreateFile();

			ps0.executeUpdate();

		}
		closeConnection(ps0, con0);
	}

	public void updateAnnullment(ArrayList annulledParm, String userParm) throws Exception {

		Connection con0 = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		Date today = new Date();
		con0 = getPooledConnection(DBASEKEY);

		PreparedStatement ps0 = con0.prepareStatement(UPDATERESERVATION_SQL);

		for (Iterator iter = annulledParm.iterator(); iter.hasNext();) {
			AnnulledDTO element = (AnnulledDTO) iter.next();

			ps0.setInt(1, 0);
			ps0.setString(2, userParm);
			ps0.setString(3, sf.format(today));
			ps0.setInt(4, element.getId());
			//Create the PDF file with the note to send by email
			CreatePDFAnulledNote createNoteAnulled = new CreatePDFAnulledNote(element.getId());
			createNoteAnulled.CreateFile();

			ps0.executeUpdate();

		}

		closeConnection(ps0, con0);

	}

}
