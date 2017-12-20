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
public class ForgotPwdForm extends ValidatorForm {
	private String email;
	
	
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

}
