
package com.nicahost.module.classified.bean;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ItemOrdered {
	private AdvertisementBean item;
	private int numItems;
	
	public ItemOrdered(AdvertisementBean _item) {
		setItem(_item);
		setNumItems(1);	 
	}

	/**
	 * @return
	 */
	public AdvertisementBean getItem() {
		return item;
	}

	/**
	 * @return
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * @param bean
	 */
	public void setItem(AdvertisementBean bean) {
		item = bean;
	}

	/**
	 * @param i
	 */
	public void setNumItems(int i) {
		numItems = i;
	}

	/**
	 * Metodos de acceso a los atributos de Item
	 * @return
	 */

	public String getItemId() {
		return getItem().getItemId();
	}
	
	public String getItemTitle() {
		return getItem().getTitle();
	}
	
	public String getItemDesc() {
		return getItem().getDesc();		
	}
	
	
	public String getItemName() {
		return getItem().getName();
	}
	
	public String getItemPhone() {
		return getItem().getPhone();
	}
	
	public String getItemEmail() {
		return getItem().getEmail();
	}
	
	public String getItemCategory() {
		return getItem().getCategory();
	}
	
	public String getItemFileName() {
		return getItem().getMyFileName();
	}
	
	public double getItemCost() {
		return getItem().getCost();
	}
	
	
	/**
	 * Metodos de manipulacion del item ordered
	 * @author henry
	 */
	
	public void incrementNumItems() {
		setNumItems(getNumItems() + 1);
	}
	
	public void cancelItem() {
		setNumItems(0);
	}
	
	public double getTotalCost() {
		return getNumItems() * getItemCost();
	}
}
