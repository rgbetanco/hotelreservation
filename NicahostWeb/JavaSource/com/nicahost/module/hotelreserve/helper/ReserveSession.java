/*
 * Created on Jul 6, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.helper;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ReserveSession
	implements HttpSessionBindingListener, Serializable {

	private Calendar initDate;
	private Calendar endDate;
	private String numNights;
	private Map roomAvailability;

	/**
	 * Metodo que limpia todas las variables de la session
	 * 
	 */

	public void clearSession() {
		this.initDate = null;
		this.endDate = null;
		this.numNights = null;	
	}

	/**
	 * 
	 */
	public ReserveSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionBindingListener#valueBound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionBindingListener#valueUnbound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}


	/**
	 * @return
	 */
	public String getNumNights() {
		return numNights;
	}

	/**
	 * @param string
	 */
	public void setNumNights(String string) {
		numNights = string;
	}

	/**
	 * @return
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @return
	 */
	public Calendar getInitDate() {
		return initDate;
	}

	/**
	 * @param calendar
	 */
	public void setEndDate(Calendar calendar) {
		endDate = calendar;
	}

	/**
	 * @param calendar
	 */
	public void setInitDate(Calendar calendar) {
		initDate = calendar;
	}

	/**
	 * @return
	 */
	public Map getRoomAvailability() {
		return roomAvailability;
	}

	/**
	 * @param collection
	 */
	public void setRoomAvailability(Map collection) {
		roomAvailability = collection;
	}

}
