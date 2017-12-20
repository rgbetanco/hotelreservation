package com.nicahost.module.classified.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class CategoryDTO implements Serializable {
	
	private String catId;
	private String catDesc;
	private String catLabel;
	private String catIcon;
	private String hits;
	private List subCategories;
	
	
	public CategoryDTO() {
		resetFields();	
	}
	
	protected void resetFields() {
		this.catId = "";
		this.catDesc = "";
		this.catLabel = "";
		this.catIcon = "";
		this.hits = "";
		this.subCategories = new ArrayList();
	}

	/**
	 * Returns the catDesc.
	 * @return String
	 */
	public String getCatDesc() {
		return catDesc;
	}

	/**
	 * Returns the catIcon.
	 * @return String
	 */
	public String getCatIcon() {
		return catIcon;
	}

	/**
	 * Returns the catId.
	 * @return String
	 */
	public String getCatId() {
		return catId;
	}

	/**
	 * Returns the catLabel.
	 * @return String
	 */
	public String getCatLabel() {
		return catLabel;
	}

	/**
	 * Sets the catDesc.
	 * @param catDesc The catDesc to set
	 */
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	/**
	 * Sets the catIcon.
	 * @param catIcon The catIcon to set
	 */
	public void setCatIcon(String catIcon) {
		this.catIcon = catIcon;
	}

	/**
	 * Sets the catId.
	 * @param catId The catId to set
	 */
	public void setCatId(String catId) {
		this.catId = catId;
	}

	/**
	 * Sets the catLabel.
	 * @param catLabel The catLabel to set
	 */
	public void setCatLabel(String catLabel) {
		this.catLabel = catLabel;
	}
	
	public void addSubCategory(SubCategoryDTO subcat) {
		subCategories.add(subcat);
	}
	
	public void addSubCategory(String id, String name) {
		addSubCategory(new SubCategoryDTO(id,name));
	}

	/**
	 * @return
	 */
	public List getSubCategories() {
		return subCategories;
	}

	/**
	 * @param list
	 */
	public void setSubCategories(List list) {
		subCategories = list;
	}

	/**
	 * @return
	 */
	public String getHits() {
		return hits;
	}

	/**
	 * @param string
	 */
	public void setHits(String string) {
		hits = string;
	}

}
