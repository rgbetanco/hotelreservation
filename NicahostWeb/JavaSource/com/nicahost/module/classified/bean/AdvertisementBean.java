package com.nicahost.module.classified.bean;

import java.io.Serializable;
import java.util.Calendar;

import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class AdvertisementBean implements Serializable {
	
	private String title;
	private String desc;
	private String name;
	private String phone;
	private String email;
	private String category;
	private String myFileName;
	private double cost;
	private String itemId;
	private String imgPath;
	private String currency;
	private String duration;
	private Calendar postedDate;
	private boolean cart;
	private String hideEmail;
	
	

	/**
	 * Constructor for InsertAdBean.
	 */
	public AdvertisementBean() {
		super();
		resetFields();
	}
	
	protected void resetFields() {
	this.title="";
	this.desc="";
	this.name="";
	this.phone="";
	this.email="";
	this.category="";		
	this.myFileName = "";
	this.imgPath = ClasificadosInitParamBean.getInstance().getValue("uploadimgpath");	
	}

	/**
	 * Returns the category.
	 * @return String
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns the desc.
	 * @return String
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Returns the email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the phone.
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the title.
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the category.
	 * @param category The category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the desc.
	 * @param desc The desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Sets the email.
	 * @param email The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the phone.
	 * @param phone The phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Sets the title.
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getMyFileName() {
		return myFileName;
	}

	/**
	 * @param string
	 */
	public void setMyFileName(String string) {
		myFileName = string;
	}

	/**
	 * @return
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param d
	 */
	public void setCost(double d) {
		cost = d;
	}

	/**
	 * @return
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param string
	 */
	public void setItemId(String string) {
		itemId = string;
	}

	/**
	 * @return
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param string
	 */
	public void setImgPath(String string) {
		imgPath = string;
	}

	/**
	 * @return
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param string
	 */
	public void setCurrency(String string) {
		currency = string;
	}

	/**
	 * @param string
	 */
	public void setDuration(String string) {
		duration = string;
	}

	/**
	 * @return
	 */
	public Calendar getPostedDate() {
		return postedDate;
	}

	/**
	 * @param calendar
	 */
	public void setPostedDate(Calendar calendar) {
		postedDate = calendar;
	}

	/**
	 * @return
	 */
	public boolean isCart() {
		return cart;
	}

	/**
	 * @param b
	 */
	public void setCart(boolean b) {
		cart = b;
	}

	/**
	 * @return
	 */
	public String getHideEmail() {
		return hideEmail;
	}

	/**
	 * @param string
	 */
	public void setHideEmail(String string) {
		hideEmail = string;
	}

}
