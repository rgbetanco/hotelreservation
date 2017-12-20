/*
 * Created on Jul 23, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PlacedReservationView implements Serializable {
	
	private String email;
	private String firstName;
	private String lastName;
	private String id;
	private String roomId;
	private String description;
	private Calendar reservationDate;
	private Calendar checkInDate;
	private Calendar checkOutDate;
	private String status;
	
	private String numNights;
	//private String guest;
	private String roomTypeName;
	private String roomTypeId;

	/**
	 * 
	 */
	public PlacedReservationView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public Calendar getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @return
	 */
	public Calendar getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
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
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public Calendar getReservationDate() {
		return reservationDate;
	}

	/**
	 * @return
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param calendar
	 */
	public void setCheckInDate(Calendar calendar) {
		checkInDate = calendar;
	}

	/**
	 * @param calendar
	 */
	public void setCheckOutDate(Calendar calendar) {
		checkOutDate = calendar;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param calendar
	 */
	public void setReservationDate(Calendar calendar) {
		reservationDate = calendar;
	}

	/**
	 * @param string
	 */
	public void setRoomId(String string) {
		roomId = string;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

	/**
	 * @return
	 */
	public String getNumNights() {
		return numNights;
	}

	/**
	 * @return
	 */
	public String getRoomTypeName() {
		return roomTypeName;
	}

	/**
	 * @param string
	 */
	public void setNumNights(String string) {
		numNights = string;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeName(String string) {
		roomTypeName = string;
	}

	/**
	 * @return
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeId(String string) {
		roomTypeId = string;
	}

}
