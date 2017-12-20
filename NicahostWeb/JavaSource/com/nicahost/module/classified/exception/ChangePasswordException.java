/*
 * Created on Feb 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.exception;

import com.nicahost.framework.common.exception.BaseException;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChangePasswordException extends BaseException {
	private static final String _msgKey = "error.changepassword";
	
	public ChangePasswordException() {
		setMessageKey(_msgKey);
	}
}
