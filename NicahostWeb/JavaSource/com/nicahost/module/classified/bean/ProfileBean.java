/*
 * Created on Feb 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.bean;

import java.util.Collection;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProfileBean {
	private String email;
	private String userName;
	private String password;
	private Collection shippingAddresses;
	private Collection creditCards;
	private String sellerAccount;
	private String status;
	
	
	/**
	 * @return
	 */
	public Collection getShippingAddresses() {
		return shippingAddresses;
	}	

	/**
	 * @return
	 */
	public Collection getCreditCards() {
		return creditCards;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param collection
	 */
	public void setShippingAddresses(Collection collection) {
		shippingAddresses = collection;
	}
	
	public void addShippingAddress(AddressBean _bean) {
		shippingAddresses.add(_bean);
	}

	/**
	 * @param collection
	 */
	public void setCreditCards(Collection collection) {
		creditCards = collection;
	}
	
	public void addCreditCard(PaymentInfoBean _bean) {
		creditCards.add(_bean);
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param string
	 */
	public void setUserName(String string) {
		userName = string;
	}

	/**
	 * @return
	 */
	public String getSellerAccount() {
		return sellerAccount;
	}

	/**
	 * @param string
	 */
	public void setSellerAccount(String string) {
		sellerAccount = string;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

}
