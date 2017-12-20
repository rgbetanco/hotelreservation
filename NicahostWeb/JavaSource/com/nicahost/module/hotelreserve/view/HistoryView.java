/*
 * Created on Jul 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HistoryView implements Serializable {
	private String id;
	private String roomNumV;
	private String emailV;
	private String reservationDateV;
	private String checkinDateV;
	private String checkoutDateV;
	private String guestV;
	private String statusV;
	private String totalV;
	private String firstNameV;
	private String lastNameV;
	private String commentV;
	
	public HistoryView()
	{
		this.roomNumV = "";
		this.emailV = "";
		this.reservationDateV="";
		this.checkinDateV="";
		this.checkoutDateV="";
		this.guestV="";
		this.statusV="";
		this.totalV="";
		this.firstNameV="";
		this.lastNameV="";
		this.commentV="";
	}

	/**
	 * @return
	 */
	public String getCheckinDateV() {
		return checkinDateV;
	}

	/**
	 * @return
	 */
	public String getCheckoutDateV() {
		return checkoutDateV;
	}

	/**
	 * @return
	 */
	public String getCommentV() {
		return commentV;
	}

	/**
	 * @return
	 */
	public String getEmailV() {
		return emailV;
	}

	/**
	 * @return
	 */
	public String getFirstNameV() {
		return firstNameV;
	}

	/**
	 * @return
	 */
	public String getGuestV() {
		return guestV;
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
	public String getLastNameV() {
		return lastNameV;
	}

	/**
	 * @return
	 */
	public String getReservationDateV() {
		return reservationDateV;
	}

	/**
	 * @return
	 */
	public String getRoomNumV() {
		return roomNumV;
	}

	/**
	 * @return
	 */
	public String getStatusV() {
		return statusV;
	}

	/**
	 * @return
	 */
	public String getTotalV() {
		return totalV;
	}

	/**
	 * @param string
	 */
	public void setCheckinDateV(String string) {
		checkinDateV = string;
	}

	/**
	 * @param string
	 */
	public void setCheckoutDateV(String string) {
		checkoutDateV = string;
	}

	/**
	 * @param string
	 */
	public void setCommentV(String string) {
		commentV = string;
	}

	/**
	 * @param string
	 */
	public void setEmailV(String string) {
		emailV = string;
	}

	/**
	 * @param string
	 */
	public void setFirstNameV(String string) {
		firstNameV = string;
	}

	/**
	 * @param string
	 */
	public void setGuestV(String string) {
		guestV = string;
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
	public void setLastNameV(String string) {
		lastNameV = string;
	}

	/**
	 * @param string
	 */
	public void setReservationDateV(String string) {
		reservationDateV = string;
	}

	/**
	 * @param string
	 */
	public void setRoomNumV(String string) {
		roomNumV = string;
	}

	/**
	 * @param string
	 */
	public void setStatusV(String string) {
		statusV = string;
	}

	/**
	 * @param string
	 */
	public void setTotalV(String string) {
		totalV = string;
	}

}
