/*
 * Created on Jul 21, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ReservedRoomView implements Serializable {
	private String roomId;
	private String price;
	private String description;	
	private String subTotal;
	private String confirmationId;
	private boolean reserved;
	
	
	/**
	 * 
	 */
	public ReservedRoomView() {
		super();
		
	}

	/**
	 * @return
	 */
	public String getConfirmationId() {
		return confirmationId;
	}

	/**
	 * @return
	 */
	public boolean isReserved() {
		return reserved;
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
	public String getSubTotal() {
		return subTotal;
	}

	/**
	 * @param string
	 */
	public void setConfirmationId(String string) {
		confirmationId = string;
	}

	/**
	 * @param b
	 */
	public void setReserved(boolean b) {
		reserved = b;
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
	public void setSubTotal(String string) {
		subTotal = string;
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
	public String getPrice() {
		return price;
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
	public void setPrice(String string) {
		price = string;
	}
	
	public void setPrice(double value) {
		price = Double.toString(value);
	}

}
