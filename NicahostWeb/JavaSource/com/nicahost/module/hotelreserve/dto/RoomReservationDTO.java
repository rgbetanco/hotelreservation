/*
 * Created on Jul 19, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dto;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomReservationDTO implements Serializable {
	private int roomId;
	private long checkInDate;
	private long checkOutDate;
	private double total;
	private int guest;
	private String email1;
	private String comment;

	
	public RoomReservationDTO() {
		super();
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
	public String getEmail1() {
		return email1;
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
	public double getTotal() {
		return total;
	}

	/**
	 * @param l
	 */
	public void setCheckInDate(long l) {
		checkInDate = l;
	}
	
	public void setCheckInDate(Calendar cal) {
		checkInDate = cal.getTime().getTime();
	}

	/**
	 * @param l
	 */
	public void setCheckOutDate(long l) {
		checkOutDate = l;
	}

	public void setCheckOutDate(Calendar cal) {
		checkOutDate = cal.getTime().getTime();;
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
	public void setEmail1(String string) {
		email1 = string;
	}

	/**
	 * @param string
	 */
	public void setRoomId(String string) {
		roomId = Integer.parseInt(string);
	}
	
	public void setRoomId(int i) {
		roomId = i;
	}

	/**
	 * @param d
	 */
	public void setTotal(double d) {
		total = d;
	}
	
	public void setTotal(String s){
		total = Double.parseDouble(s);
	}

	/**
	 * @return
	 */
	public int getGuest() {
		return guest;
	}

	/**
	 * @param i
	 */
	public void setGuest(int i) {
		guest = i;
	}
	
	public void setGuest(String s) {
		guest = Integer.parseInt(s);
	}


}
