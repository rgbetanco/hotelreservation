/*
 * Created on Feb 27, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EmailForm extends ValidatorForm {
	private String toEmail="";
	private String fromEmail="";
	private String productId="";
	private String productDescription="";
	private String subject="";
	private String body="";
	private String hideEmail="";
	private String copyEmail="";
	private String name="";
	

	/**
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @return
	 */
	public String getCopyEmail() {
		return copyEmail;
	}

	/**
	 * @return
	 */
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * @return
	 */
	public String getHideEmail() {
		return hideEmail;
	}

	/**
	 * @return
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @return
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return
	 */
	public String getToEmail() {
		return toEmail;
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
	public void setCopyEmail(String string) {
		copyEmail = string;
	}

	/**
	 * @param string
	 */
	public void setFromEmail(String string) {
		fromEmail = string;
	}

	/**
	 * @param string
	 */
	public void setHideEmail(String string) {
		hideEmail = string;
	}

	/**
	 * @param string
	 */
	public void setProductDescription(String string) {
		productDescription = string;
	}

	/**
	 * @param string
	 */
	public void setProductId(String string) {
		productId = string;
	}

	/**
	 * @param string
	 */
	public void setSubject(String string) {
		subject = string;
	}

	/**
	 * @param string
	 */
	public void setToEmail(String string) {
		toEmail = string;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

}
