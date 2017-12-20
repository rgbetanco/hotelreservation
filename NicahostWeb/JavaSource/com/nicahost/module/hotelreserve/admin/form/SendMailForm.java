/*
 * Created on Jul 12, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SendMailForm extends ActionForm {
	private String email;
	private String subject;
	private String body;
	
	public SendMailForm(){
		this.email=null;
		this.subject=null;
		this.body=null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();
		
		
			if (null == this.email) {
				errors.add("email", new ActionMessage("error.required"));				
			}
		
			if (null == this.subject || this.subject.trim().length() == 0 ) {
				errors.add("dateTimeIn", new ActionMessage("error.required"));
			}
		
			if (null == this.body || this.body.trim().length() == 0 ) {
				errors.add("dateTimeOut", new ActionMessage("error.required"));
			}
		
			return errors;
		}
	
	/**
	 * @return
	 */
	public String getBody() {
		return body;
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
	public String getSubject() {
		return subject;
	}

	/**
	 * @param string
	 */
	public void setBody(String string) {
		body = string;
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
	public void setSubject(String string) {
		subject = string;
	}

}
