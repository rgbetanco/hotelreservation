/*
 * Created on Jul 22, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.dto;

import java.io.Serializable;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomsTableDTO implements Serializable {
	private int roomId;
	private int roomType;
	private int maxPeople;
	private String description;
	private double price;
	private String blocked;
	
	public RoomsTableDTO(){
		this.roomId = 0;
		this.roomType = 0;
		this.maxPeople = 0;
		this.description = "";
		this.price = 0.00;
		this.blocked = "";
	}

	/**
	 * @return
	 */
	public String getBlocked() {
		return blocked;
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
	public int getMaxPeople() {
		return maxPeople;
	}

	/**
	 * @return
	 */
	public double getPrice() {
		return price;
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
	public int getRoomType() {
		return roomType;
	}

	/**
	 * @param c
	 */
	public void setBlocked(String c) {
		blocked = c;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param i
	 */
	public void setMaxPeople(int i) {
		maxPeople = i;
	}

	/**
	 * @param d
	 */
	public void setPrice(double d) {
		price = d;
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
	public void setRoomType(int t) {
		roomType = t;
	}

}
