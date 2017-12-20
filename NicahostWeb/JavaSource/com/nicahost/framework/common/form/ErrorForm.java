package com.nicahost.framework.common.form;

import org.apache.struts.action.ActionForm;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ErrorForm extends ActionForm {
    private String title;           // The error's page title
    private String reference;       // The error identifier
    private String code;            // The error number
    private String text;            // A description of the error
    
    
	/**
	 * Returns the code.
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns the reference.
	 * @return String
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Returns the text.
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns the title.
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the code.
	 * @param code The code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Sets the reference.
	 * @param reference The reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Sets the text.
	 * @param text The text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Sets the title.
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
