/*
 * Created on Jul 19, 2005
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
public class CardDTO implements Serializable {
	private String cardType;
	private String cardNumber;
	private String cardMonth;
	private String cardYear;
	private String cardHolder;
	/**
	 * @return
	 */
	public String getCardHolder() {
		return cardHolder;
	}

	/**
	 * @return
	 */
	public String getCardMonth() {
		return cardMonth;
	}

	/**
	 * @return
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @return
	 */
	public String getCardYear() {
		return cardYear;
	}

	/**
	 * @param string
	 */
	public void setCardHolder(String string) {
		cardHolder = string;
	}

	/**
	 * @param string
	 */
	public void setCardMonth(String string) {
		cardMonth = string;
	}

	/**
	 * @param string
	 */
	public void setCardNumber(String string) {
		cardNumber = string;
	}

	/**
	 * @param string
	 */
	public void setCardType(String string) {
		cardType = string;
	}

	/**
	 * @param string
	 */
	public void setCardYear(String string) {
		cardYear = string;
	}

}
