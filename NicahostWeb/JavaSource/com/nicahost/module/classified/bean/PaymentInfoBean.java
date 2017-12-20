/*
 * Created on Feb 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.bean;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PaymentInfoBean {
	private String cardType;
	private String cardNumber;
	private String cardMonth;
	private String cardYear;
	private String cardName;
	private String cardCCV;
	private String cardId;
	

	/**
	 * @return
	 */
	public String getCardMonth() {
		return cardMonth;
	}

	/**
	 * @return
	 */
	public String getCardName() {
		return cardName;
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
	public void setCardMonth(String string) {
		cardMonth = string;
	}

	/**
	 * @param string
	 */
	public void setCardName(String string) {
		cardName = string;
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

	/**
	 * @return
	 */
	public String getCardCCV() {
		return cardCCV;
	}

	/**
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param string
	 */
	public void setCardCCV(String string) {
		cardCCV = string;
	}

	/**
	 * @param string
	 */
	public void setCardId(String string) {
		cardId = string;
	}

}
