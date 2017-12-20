/*
 * Created on Nov 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.creditcard.dto;

import java.io.Serializable;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SaleResponseDTO implements Serializable {
	/* REQUIRED */
	private String transactionId;		// Server-generated transaction Id, which uniquely identifies a transaction
	private String amount;				// Echoed back to requesting application
	private String resultCode;			// RealPay especific transaction result code
		
	/* OPTIONAL */
	private String reasonCode;			// Passes host and network especific response data back to requesting application
	private String resultText;			// Textual Explanation of response
	
	/**
	 * @return
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @return
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @return
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @return
	 */
	public String getResultText() {
		return resultText;
	}

	/**
	 * @return
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param string
	 */
	public void setAmount(String string) {
		amount = string;
	}

	/**
	 * @param string
	 */
	public void setReasonCode(String string) {
		reasonCode = string;
	}

	/**
	 * @param string
	 */
	public void setResultCode(String string) {
		resultCode = string;
	}

	/**
	 * @param string
	 */
	public void setResultText(String string) {
		resultText = string;
	}

	/**
	 * @param string
	 */
	public void setTransactionId(String string) {
		transactionId = string;
	}

}
