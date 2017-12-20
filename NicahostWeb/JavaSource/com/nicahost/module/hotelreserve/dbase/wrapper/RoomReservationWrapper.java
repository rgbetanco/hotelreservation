/*
 * Created on Jul 19, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dbase.wrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.common.util.UniqueIdentifierGenerator;
import com.nicahost.module.hotelreserve.dto.RoomReservationDTO;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomReservationWrapper extends DBBaseDAO {
	//<-- Primary key
	private int reservationId;
	//-->
	private int roomId;
	private long reservationDate;
	private long checkInDate;
	private long checkOutDate;
	private int guest;
	private int status;
	private double total;
	private String email;
	private String comment;
	private String confirmationCode; 
	
	//Field's size
	private static final int EMAIL_SZ = 96;
	private static final int COMMENT_SZ = 196;
	private static final int CONFIRMATIONID_SZ = 12;
	

	static Logger log = Logger.getLogger(ClientInsertWrapper.class);

	private static final String DBASEKEY = "dsHotel";
	private static final String INSERT_ROOMRESERVATION_SQL =
		//								1		2				3			4		  5			6	  			7		8		9	
		"insert into roomreservation (roomid,reservationdate,checkindate,checkoutdate,guest,status,total,email,comment,confirmationcode) "
			+ " values(?,?,?,?,?,?,?,?,?,?)";

	public RoomReservationWrapper() {
		super();
		initialize();
	}
	
	public RoomReservationWrapper(RoomReservationDTO dto) {
		this();
		setCheckInDate(dto.getCheckInDate());
		setCheckOutDate(dto.getCheckOutDate());
		setComment(dto.getComment());
		setEmail(dto.getEmail1());
		setRoomId(dto.getRoomId());
		setTotal(dto.getTotal());
	}
	
	protected void initialize() {
		email = "";
		comment = "";
		confirmationCode = UniqueIdentifierGenerator.generateCode();		
		reservationDate = getCurrentDate();		//El tiempo al momento de hacer el insert
		status = 2;								//Siempre por defecto siempre sera igual a 2 (on hold)
		
	}
	
	protected boolean validate() {
		boolean isOK = true;
		comment = comment==null?"":comment;
				
		email = email.length()>EMAIL_SZ?email.substring(0,EMAIL_SZ):email;
		comment = comment.length()>COMMENT_SZ?comment.substring(0,COMMENT_SZ):comment;
		confirmationCode = confirmationCode.length()>CONFIRMATIONID_SZ?confirmationCode.substring(0,CONFIRMATIONID_SZ):confirmationCode;		
		
		return isOK;
	}
	
	private long getCurrentDate() {
		long result = System.currentTimeMillis();
		
		return result;
	}
	
	protected boolean executeSQLInsert() throws SQLException {
		PreparedStatement ps = null;	
		Connection conn = null;
		boolean result=false;
			try {			
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(INSERT_ROOMRESERVATION_SQL);
				ps.setInt(1,roomId);
				ps.setLong(2,reservationDate);
				ps.setLong(3,checkInDate);
				ps.setLong(4,checkOutDate);
				ps.setInt(5,guest);				
				ps.setInt(6,status);
				ps.setDouble(7,total);
				ps.setString(8,email);
				ps.setString(9,comment);
				ps.setString(10,confirmationCode);			

				result = ps.executeUpdate()>0?true:false;
				
			} finally {
				try {				
					closeConnection(ps,conn);
				} catch (Exception ex) {
					
				}
			}
		return result;
	}	
	
	public boolean execute() throws SQLException {
		boolean result = false;
		
		if (validate()) {
			result = executeSQLInsert();
		}
		
		return result;
	}
	
	public boolean execute(RoomReservationDTO dto ) throws SQLException {

		RoomReservationWrapper wrapper = new RoomReservationWrapper(dto);
		return wrapper.execute();
	}	
	
	/**
	 * @return
	 */
	public long getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @return
	 */
	public long getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public int getGuest() {
		return guest;
	}

	/**
	 * @return
	 */
	public long getReservationDate() {
		return reservationDate;
	}

	/**
	 * @return
	 */
	public int getReservationId() {
		return reservationId;
	}

	/**
	 * @return
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param l
	 */
	public void setCheckInDate(long l) {
		checkInDate = l;
	}

	/**
	 * @param l
	 */
	public void setCheckOutDate(long l) {
		checkOutDate = l;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param i
	 */
	public void setGuest(int i) {
		guest = i;
	}

	/**
	 * @param l
	 */
	public void setReservationDate(long l) {
		reservationDate = l;
	}

	/**
	 * @param i
	 */
	public void setReservationId(int i) {
		reservationId = i;
	}

	/**
	 * @param i
	 */
	public void setRoomId(int i) {
		roomId = i;
	}

	/**
	 * @param i
	 */
	public void setStatus(int i) {
		status = i;
	}

	/**
	 * @param d
	 */
	public void setTotal(double d) {
		total = d;
	}

	/**
	 * @return
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * @param string
	 */
	public void setConfirmationCode(String string) {
		confirmationCode = string;
	}

}
