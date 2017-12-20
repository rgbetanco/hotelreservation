/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step01Form extends ValidatorForm {
	
	private String roomTypeId;
	private String initDate;
	private String endDate;
	private String serverDate;
	private String adult;
	private String child;
	

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
/*	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		this.initDate = null;
		this.endDate = null;
		this.roomType = null;
	}
*/
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	/*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		
		if (null == this.roomType) {
			errors.add("roomType", new ActionMessage("error.required"));				
		}
		
		if (null == this.initDate || this.initDate.trim().length() == 0 ) {
			errors.add("dateTimeIn", new ActionMessage("error.required"));
		}
		
		if (null == this.endDate || this.endDate.trim().length() == 0 ) {
			errors.add("dateTimeOut", new ActionMessage("error.required"));
		}
		
		return errors;
	}
*/
	/**
	 * @return
	 */
	public String getInitDate() {
		return initDate;
	}

	/**
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @return
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param string
	 */
	public void setInitDate(String string) {
		initDate = string;
	}

	/**
	 * @param string
	 */
	public void setEndDate(String string) {
		endDate = string;
	}

	/**
	 * @param string
	 */
	public void setRoomTypeId(String string) {
		roomTypeId = string;
	}

	/**
	 * @return
	 */
	public String getServerDate() {
		return serverDate;
	}

	/**
	 * @param string
	 */
	public void setServerDate(String string) {
		serverDate = string;
	}

	/**
	 * @return
	 */
	public String getAdult() {
		return adult;
	}

	/**
	 * @return
	 */
	public String getChild() {
		return child;
	}

	/**
	 * @param string
	 */
	public void setAdult(String string) {
		adult = string;
	}

	/**
	 * @param string
	 */
	public void setChild(String string) {
		child = string;
	}

}
