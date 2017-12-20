/*
 * Created on Jun 15, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GalleryView implements Serializable {
	private String id;
	private String picName;
	private String toolTipLabel;
	
	public GalleryView() {
		this.id = "";
		this.picName = "";
		this.toolTipLabel = "";
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
	public String getPicName() {
		return picName;
	}

	/**
	 * @return
	 */
	public String getToolTipLabel() {
		return toolTipLabel;
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
	public void setPicName(String string) {
		picName = string;
	}

	/**
	 * @param string
	 */
	public void setToolTipLabel(String string) {
		toolTipLabel = string;
	}

}
