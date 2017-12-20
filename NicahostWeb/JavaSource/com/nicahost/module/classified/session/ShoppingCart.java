/*
 * Created on Feb 6, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.session;

import java.util.Iterator;
import java.util.Vector;

import com.nicahost.module.classified.bean.ItemOrdered;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShoppingCart {
	
	private Vector itemsOrdered;
	private double itemsTotal;
	
	public ShoppingCart() {
		itemsOrdered = new Vector();
	}
	
	public Vector getItemsOrdered() {
		return itemsOrdered;
	}
	
	
	public synchronized void addItem(String _itemId) throws Exception {

		for (Iterator iter = itemsOrdered.iterator(); iter.hasNext();) {
			ItemOrdered element = (ItemOrdered) iter.next();
			if (element.getItemId().equals(_itemId)) {
				element.incrementNumItems();
				return;
			}
		}
		
		ClassifiedService service = ClassifiedService.getInstance();
		
		ItemOrdered newOrdered = new ItemOrdered(service.getItem(_itemId));
		itemsOrdered.add(newOrdered);		
				
	}

	public synchronized void setNumOrdered(String _itemId, int numOrdered) throws Exception {
		ItemOrdered order;
		
		for (int i=0; i<itemsOrdered.size(); i++) {
			order = (ItemOrdered) itemsOrdered.elementAt(i);
			if (order.getItemId().equals(_itemId)) {
				if (numOrdered <= 0) {				
					itemsOrdered.removeElementAt(i);
				} else {
					order.setNumItems(numOrdered);
				}
				return;
			}
		}
		
		ItemOrdered newOrder = new ItemOrdered(ClassifiedService.getInstance().getItem(_itemId));
		itemsOrdered.add(newOrder);
	}
	
	public synchronized double getItemsTotal() throws Exception {
		
		ItemOrdered order;

		for (int i=0; i<itemsOrdered.size(); i++) {
			order = (ItemOrdered) itemsOrdered.elementAt(i);
			itemsTotal += order.getTotalCost();
		}
		
		
		return itemsTotal;
	}
	

}
