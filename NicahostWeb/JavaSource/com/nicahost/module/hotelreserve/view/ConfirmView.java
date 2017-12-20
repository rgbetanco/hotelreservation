/*
 * Created on Jul 21, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConfirmView implements Serializable {
	
	private Calendar initDateCal;
	private Calendar endDateCal;
	private String numNights;
	//private String numPersons;
	private String roomTypeName;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String city;
	private String country;
	private String zip;
	private Collection selectedRooms;
	private String cardType;
	private String cardNumberEnc;
	private String expDate;
	private String confirmationCode;
	
	/**
	 * 
	 */
	public ConfirmView() {
		super();
		
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getCardNumberEnc() {
		return cardNumberEnc;
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
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public Calendar getEndDateCal() {
		return endDateCal;
	}

	/**
	 * @return
	 */
	public String getExpDate() {
		return expDate;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public Calendar getInitDateCal() {
		return initDateCal;
	}

	/**
	 * @return
	 */
	public String getNumNights() {
		return numNights;
	}


	/**
	 * @return
	 */
	public String getRoomTypeName() {
		return roomTypeName;
	}

	/**
	 * @return
	 */
	public Collection getSelectedRooms() {
		return selectedRooms;
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
	public void setCardNumberEnc(String string) {
		cardNumberEnc = string;
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
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param calendar
	 */
	public void setEndDateCal(Calendar calendar) {
		endDateCal = calendar;
	}

	/**
	 * @param string
	 */
	public void setExpDate(String string) {
		expDate = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param calendar
	 */
	public void setInitDateCal(Calendar calendar) {
		initDateCal = calendar;
	}

	/**
	 * @param string
	 */
	public void setNumNights(String string) {
		numNights = string;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeName(String string) {
		roomTypeName = string;
	}

	/**
	 * @param collection
	 */
	public void setSelectedRooms(Collection collection) {
		selectedRooms = collection;
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
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @return
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * @param string
	 */
	public void setConfirmationCode(String string) {
		confirmationCode = string;
	}

}
