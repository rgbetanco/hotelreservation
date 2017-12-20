package com.nicahost.framework.common.view;

import java.io.Serializable;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class OptionView implements Serializable, Comparable {
	
	private String label;	
	private String value;

	/**
	 * Constructor for OptionView.
	 */
	public OptionView() {
		super();
		this.value ="";
		this.label = "";		
	}
	
	public OptionView(String label, String value) {
		this.value = value;
		this.label = label;	
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * Taken from: http://www.javaworld.com/javaworld/jw-12-2002/jw-1227-sort.html
	 *  
	 */
	public int compareTo(Object o) {
		OptionView view = (OptionView) o; //if this doesn't work throws a class cast exception
		 
		return this.label.compareTo(view.getLabel());
	}


	/**
	 * Returns the label.
	 * @return String
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Returns the value.
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the label.
	 * @param label The label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Sets the value.
	 * @param value The value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
