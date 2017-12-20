/*
 * Created on Nov 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.creditcard.dto;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AutRequestDTO implements Serializable {
	/* REQUIRED */
	private String cardNumber;
	private String amount;
	private String month;
	private String year;
	/* OPTIONAL */
	private String tax;
	private String taxExemptionId;
	private String purchaseOrder;
	private String address;
	private String zip;
	private String cvc;
	private String trxPassword;
	private String orderId;
	private String transactionId;
	
	
	/**
	 * @return
	 */
	public String getAddress() {
		return address;
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
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return
	 */
	public String getCvc() {
		return cvc;
	}

	/**
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return
	 */
	public String getOrderId() {
		return orderId;
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
	public String getTax() {
		return tax;
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
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @return
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param string
	 */
	public void setAmount(String val) {
		
		NumberFormat df = NumberFormat.getInstance();	
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		double valor = Double.parseDouble(val);
		val = df.format(valor);
		String digits = val.substring(val.lastIndexOf(".")+1);
		try {			
			Number n = df.parse(val);
			val = n.toString().concat(digits);
		} catch (ParseException pex) {

		}
				
		amount = val;
	}

	
	public void setAmount(double val) {
		String tmp = Double.toString(val);
		this.setAmount(tmp);
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
	public void setCvc(String string) {
		cvc = string;
	}

	/**
	 * @param string
	 */
	public void setMonth(String string) {
		month = string;
	}

	/**
	 * @param string
	 */
	public void setOrderId(String string) {
		orderId = string;
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
	public void setTax(String string) {
		tax = string;
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
	public void setTransactionId(String string) {
		transactionId = string;
	}

	/**
	 * @param string
	 */
	public void setTrxPassword(String string) {
		trxPassword = string;
	}

	/**
	 * @param string
	 */
	public void setYear(String string) {
		year = string;
	}

	/**
	 * @param string
	 */
	public void setZip(String string) {
		zip = string;
	}

}
