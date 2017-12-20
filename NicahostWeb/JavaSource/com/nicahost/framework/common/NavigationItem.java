package com.nicahost.framework.common;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class NavigationItem {
	private String mText;
	private String mURLReference;
	public NavigationItem(String Text, String URLReference) {
		mText = Text;
		mURLReference = URLReference;
	}
	public String getText() {
		return mText;
	}
	public String getURLReference() {
		return mURLReference;
	}
}
