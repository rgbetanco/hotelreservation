/*
 * Created on Feb 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.form;

import org.apache.struts.validator.ValidatorForm;
/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChangePwdForm extends ValidatorForm {
	private String email;
	private String password;
	private String retypepassword;
	private String oldPassword;
	
	
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
	 * @return
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param string
	 */
	public void setOldPassword(String string) {
		oldPassword = string;
	}

	/**
	 * @return
	 */
	public String getRetypepassword() {
		return retypepassword;
	}

	/**
	 * @param string
	 */
	public void setRetypepassword(String string) {
		retypepassword = string;
	}

}
