package com.nicahost.framework.common.form;

import java.io.Serializable;
import java.util.Vector;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class HeaderForm implements Serializable {


    private Vector navigationItems;
    
    
    
	/**
	 * Returns the navigationItems.
	 * @return Vector
	 */
	public Vector getNavigationItems() {
		return navigationItems;
	}

	/**
	 * Sets the navigationItems.
	 * @param navigationItems The navigationItems to set
	 */
	public void setNavigationItems(Vector navigationItems) {
		this.navigationItems = navigationItems;
	}

}
