/*
 * Created on Feb 15, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.form;

import org.apache.struts.action.ActionForm;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SearchForm extends ActionForm {
	private String criteria;
	private String catId;
	

	/**
	 * @return
	 */
	public String getCriteria() {
		return criteria;
	}

	/**
	 * @param string
	 */
	public void setCriteria(String string) {
		criteria = string;
	}

	/**
	 * @return
	 */
	public String getCatId() {
		return catId;
	}

	/**
	 * @param string
	 */
	public void setCatId(String string) {
		catId = string;
	}

}
