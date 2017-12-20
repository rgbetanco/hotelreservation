/*
 * Created on Jun 15, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomDTO implements Serializable {

	private long id;
	private int roomType;
	private int maxPeople;
	private String description;
	private double price;
	private ArrayList features;
	private int maxRooms;

	
	//DTV: data transfer variable
	
	public RoomDTO() {
		
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getMaxPeople() {
		return maxPeople;
	}

	/**
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return
	 */
	public int getRoomType() {
		return roomType;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param l
	 */
	public void setId(long l) {
		id = l;
	}

	/**
	 * @param i
	 */
	public void setMaxPeople(int i) {
		maxPeople = i;
	}

	/**
	 * @param d
	 */
	public void setPrice(double d) {
		price = d;
	}

	/**
	 * @param i
	 */
	public void setRoomType(int i) {
		roomType = i;
	}

	/**
	 * @return
	 */
	public ArrayList getFeatures() {
		return features;
	}

	public void addFeature(Object feature) {
		if (this.features == null) {
			this.features = new ArrayList();
		}
		
		this.features.add(feature);
	}
	/**
	 * @return
	 */
	public int getMaxRooms() {
		return maxRooms;
	}

	/**
	 * @param i
	 */
	public void setMaxRooms(int i) {
		maxRooms = i;
	}

}
