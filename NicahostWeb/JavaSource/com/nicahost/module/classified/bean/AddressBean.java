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
public class AddressBean {
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String country;
	private boolean isSellerDefault;
	
	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
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
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string
	 */
	public void setCountry(String string) {
		country = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setPhone(String string) {
		phone = string;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

	/**
	 * @param string
	 */
	public void setZip(String string) {
		zip = string;
	}



	/**
	 * @return
	 */
	public boolean isSellerDefault() {
		return isSellerDefault;
	}
	
	public boolean getIsSellerDefault() {
		return isSellerDefault;
	}

	/**
	 * @param b
	 */
	public void setSellerDefault(boolean b) {
		isSellerDefault = b;
	}

}
