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
public class AutResponseDTO implements Serializable {
	/* REQUIRED */
	private String transactionId;		//Server generated tx id which uniquely identifies a  tx.  All future tx for this tx must ref the tx id
	private String amount;				//Echoed back to requesting app
	private String resultCode;			//RealPay specific tx result code
	/* OPTIONAL */
	private String reasonCode;			//Passes host and network specific response data back to requesting application
	private String resultText;			//Textual Explanation of Response
	private String fraudScore;			//Provides a fraud score of the tx based on AVS and processing responses
	
	public AutResponseDTO() {
		this.transactionId = "";
		this.amount = "";
		this.resultCode = "";
		this.reasonCode = "";
		this.resultText = "";
		this.fraudScore = "";
	}
	
	/**
	 * @return
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @return
	 */
	public String getFraudScore() {
		return fraudScore;
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
	public void setFraudScore(String string) {
		fraudScore = string;
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
