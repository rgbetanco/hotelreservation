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
public class SaleRequestDTO implements Serializable {
	/* REQUIRED */
	private String transactionId;		//Server-generated transaction id, which uniquely identifies a transaction
	private String amount;				//Amount to bill to card
	/* OPTIONAL */
	private String taxAmount;			//
	private String taxExemptionId;		//
	private String purchaseOrder;		//
	private String trxPassword;			// Password assigned by RealPay system administrator
	private String trackingNumber;		// Number used to track shipped goods
	
	/**
	 * @return
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @return
	 */
	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	/**
	 * @return
	 */
	public String getTaxAmount() {
		return taxAmount;
	}

	/**
	 * @return
	 */
	public String getTaxExemptionId() {
		return taxExemptionId;
	}

	/**
	 * @return
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * @return
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @return
	 */
	public String getTrxPassword() {
		return trxPassword;
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
	public void setPurchaseOrder(String string) {
		purchaseOrder = string;
	}

	/**
	 * @param string
	 */
	public void setTaxAmount(String string) {
		taxAmount = string;
	}

	/**
	 * @param string
	 */
	public void setTaxExemptionId(String string) {
		taxExemptionId = string;
	}

	/**
	 * @param string
	 */
	public void setTrackingNumber(String string) {
		trackingNumber = string;
	}

	/**
	 * @param string
	 */
	public void setTransactionId(String string) {
		transactionId = string;
	}

	/**
	 * @param string
	 */
	public void setTrxPassword(String string) {
		trxPassword = string;
	}

}
