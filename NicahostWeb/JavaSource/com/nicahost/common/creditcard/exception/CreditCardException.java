/*
 * Created on Jul 6, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.creditcard.exception;

import com.nicahost.framework.common.exception.BaseException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CreditCardException extends BaseException {

	/**
	 * 
	 */
	public CreditCardException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rootCause
	 */
	public CreditCardException(Throwable rootCause) {
		super(rootCause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msgKey
	 */
	public CreditCardException(String msgKey) {
		super(msgKey);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msgKey
	 * @param args
	 */
	public CreditCardException(String msgKey, Object[] args) {
		super(msgKey, args);
		// TODO Auto-generated constructor stub
	}

}
