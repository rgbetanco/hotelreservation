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
public class SignInForm extends ValidatorForm {
	private String email;
	private String password;
	private String nextview;
	
	
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
	public String getNextview() {
		return nextview;
	}

	/**
	 * @param string
	 */
	public void setNextview(String string) {
		nextview = string;
	}

}
