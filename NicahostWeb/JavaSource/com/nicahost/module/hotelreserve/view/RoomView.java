/*
 * Created on Jun 15, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.view;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoomView implements Serializable {


	private String id;
	private String roomType;
	private String maxPeople;
	private String description;
	private String price;
	private String blocked;

	private ArrayList photoGallery;
	
	public RoomView() {
	//TODO: setear las variables a blanco ""	
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
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getMaxPeople() {
		return maxPeople;
	}

	/**
	 * @return
	 */
	public ArrayList getPhotoGallery() {
		return photoGallery;
	}

	public GalleryView getPhotoAt(int val) {
		return (GalleryView) photoGallery.get(val); 
	}

	/**
	 * @return
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return
	 */
	public String getRoomType() {
		return roomType;
	}



	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
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
	public void setMaxPeople(String string) {
		maxPeople = string;
	}

	/**
	 * @param collection
	 */
	public void setPhotoGallery(ArrayList collection) {
		photoGallery = collection;
	}

	/**
	 * @param string
	 */
	public void setPrice(String string) {
		price = string;
	}

	/**
	 * @param string
	 */
	public void setRoomType(String string) {
		roomType = string;
	}

	/**
	 * @return
	 */
	public String getBlocked() {
		return blocked;
	}

	/**
	 * @param string
	 */
	public void setBlocked(String string) {
		blocked = string;
	}

}
