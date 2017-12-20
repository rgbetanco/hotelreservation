/*
 * Created on Jul 23, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.form;

import org.apache.struts.action.ActionForm;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LoginForm extends ActionForm {

	private String user;
	private String pass;
	
	/**
	 * 
	 */
	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param string
	 */
	public void setPass(String string) {
		pass = string;
	}

	/**
	 * @param string
	 */
	public void setUser(String string) {
		user = string;
	}

}
