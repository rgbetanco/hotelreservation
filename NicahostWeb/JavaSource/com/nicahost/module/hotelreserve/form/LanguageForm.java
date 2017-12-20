/*
 * Created on Jul 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LanguageForm extends ActionForm {

	private String lang;

/* (non-Javadoc)
 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
 */
public void reset(ActionMapping arg0, HttpServletRequest arg1) {
	
	this.lang = null;
}

	/**
	 * @return
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param string
	 */
	public void setLang(String string) {
		lang = string;
	}

}
