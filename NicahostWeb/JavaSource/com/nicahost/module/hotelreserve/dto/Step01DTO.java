/*
 * Created on Jun 15, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dto;

import java.io.Serializable;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step01DTO implements Serializable {
	
	private int roomType;
	private long dateTimeIn;
	private long dateTimeOut;

	/**
	 * @return
	 */

	/**
	 * @return
	 */
	public long getDateTimeIn() {
		return dateTimeIn;
	}

	/**
	 * @return
	 */
	public long getDateTimeOut() {
		return dateTimeOut;
	}

	/**
	 * @return
	 */
	public int getRoomType() {
		return roomType;
	}

	/**
	 * @param l
	 */
	public void setDateTimeIn(long l) {
		dateTimeIn = l;
	}

	/**
	 * @param l
	 */
	public void setDateTimeOut(long l) {
		dateTimeOut = l;
	}

	/**
	 * @param i
	 */
	public void setRoomType(int i) {
		roomType = i;
	}

}
