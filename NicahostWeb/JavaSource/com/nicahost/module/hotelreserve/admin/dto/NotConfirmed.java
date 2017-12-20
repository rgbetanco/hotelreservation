/*
 * Created on Jul 11, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.dto;

import java.io.Serializable;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotConfirmed implements Serializable {
	private int id;
	
	public NotConfirmed(){
		this.id=0;
	}
	

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

}
