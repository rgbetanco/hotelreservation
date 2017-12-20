/*
 * Created on Apr 6, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.dto;

import java.io.Serializable;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SubCategoryDTO implements Serializable {
	private String id;
	private String name;
	
	
	public SubCategoryDTO() {
		
	}
	
	public SubCategoryDTO(String in_id, String in_name) {
		id = in_id;
		name = in_name;
	}
	
	/**
	 * @return
	 */
	public String getId() {
		return id;
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
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

}
