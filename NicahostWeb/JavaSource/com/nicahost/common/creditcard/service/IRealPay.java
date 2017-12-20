/*
 * Created on Nov 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.creditcard.service;

import java.util.HashMap;


/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class IRealPay {

	// Error codes
	public static final String ERRCODE_0000 = "0000";
	public static final String ERRCODE_9999 = "9999";
	public static final String ERRCODE_0001 = "0001";
	public static final String ERRCODE_0002 = "0002";
	public static final String ERRCODE_0003 = "0003";
	public static final String ERRCODE_0004 = "0004";
	public static final String ERRCODE_0005 = "0005";
	public static final String ERRCODE_0006 = "0006";
	public static final String ERRCODE_0007 = "0007";
	public static final String ERRCODE_0008 = "0008";
	public static final String ERRCODE_0009 = "0009";
	public static final String ERRCODE_0010 = "0010";
	public static final String ERRCODE_0011 = "0011";
	public static final String ERRCODE_0012 = "0012";
	public static final String ERRCODE_0013 = "0013";
	public static final String ERRCODE_0014 = "0014";
	public static final String ERRCODE_0015 = "0015";
	public static final String ERRCODE_0016 = "0016";
	public static final String ERRCODE_0017 = "0017";
	public static final String ERRCODE_0018 = "0018";
	public static final String ERRCODE_0019 = "0019";
	public static final String ERRCODE_0020 = "0020";
	public static final String ERRCODE_0021 = "0021";
	public static final String ERRCODE_0022 = "0022";
	public static final String ERRCODE_AAAA = "AAAA";
	// Text messages
	protected static final String ERRMSG_0000 = "Transaction received and approved";
	protected static final String ERRMSG_9999 = "Transaction received but declined";
	protected static final String ERRMSG_0001 = "Host unavailable";
	protected static final String ERRMSG_0002 = "Invalid origination IP address";
	protected static final String ERRMSG_0003 = "Invalid username";
	protected static final String ERRMSG_0004 = "Invalid transaction password";
	protected static final String ERRMSG_0005 = "SSL Port Only";
	protected static final String ERRMSG_0006 = "Message version not supported";
	protected static final String ERRMSG_0007 = "Invalid Sender Name";
	protected static final String ERRMSG_0008 = "Duplicate Request ID";
	protected static final String ERRMSG_0009 = "Message type not supported";
	protected static final String ERRMSG_0010 = "Invalid Amount. Amount is too large or not valid";
	protected static final String ERRMSG_0011 = "Invalid Amount. Amount exceeds auth amount by more than is allowed";
	protected static final String ERRMSG_0012 = "Invalid transaction ID";
	protected static final String ERRMSG_0013 = "Invalid Device";
	protected static final String ERRMSG_0014 = "Invalid Merchant";
	protected static final String ERRMSG_0015 = "Device is not active";
	protected static final String ERRMSG_0016 = "Merchant is not active";
	protected static final String ERRMSG_0017 = "System Malfunction";
	protected static final String ERRMSG_0018 = "Unsupported Transaction";
	protected static final String ERRMSG_0019 = "No active batch for specified device";
	protected static final String ERRMSG_0020 = "Invalid card";
	protected static final String ERRMSG_0021 = "Expired Card";
	protected static final String ERRMSG_0022 = "Pin Block Error";
	protected static final String ERRMSG_AAAA = "Communication link error or unknown error";
	// Message keys (for Internationalisation in Struts)
	protected static final String ERRKEY_0000 = "error.realpay.0000";
	protected static final String ERRKEY_9999 = "error.realpay.9999";
	protected static final String ERRKEY_0001 = "error.realpay.0001";
	protected static final String ERRKEY_0002 = "error.realpay.0002";
	protected static final String ERRKEY_0003 = "error.realpay.0003";
	protected static final String ERRKEY_0004 = "error.realpay.0004";
	protected static final String ERRKEY_0005 = "error.realpay.0005";
	protected static final String ERRKEY_0006 = "error.realpay.0006";
	protected static final String ERRKEY_0007 = "error.realpay.0007";
	protected static final String ERRKEY_0008 = "error.realpay.0008";
	protected static final String ERRKEY_0009 = "error.realpay.0009";
	protected static final String ERRKEY_0010 = "error.realpay.0010";
	protected static final String ERRKEY_0011 = "error.realpay.0011";
	protected static final String ERRKEY_0012 = "error.realpay.0012";
	protected static final String ERRKEY_0013 = "error.realpay.0013";
	protected static final String ERRKEY_0014 = "error.realpay.0014";
	protected static final String ERRKEY_0015 = "error.realpay.0015";
	protected static final String ERRKEY_0016 = "error.realpay.0016";
	protected static final String ERRKEY_0017 = "error.realpay.0017";
	protected static final String ERRKEY_0018 = "error.realpay.0018";
	protected static final String ERRKEY_0019 = "error.realpay.0019";
	protected static final String ERRKEY_0020 = "error.realpay.0020";
	protected static final String ERRKEY_0021 = "error.realpay.0021";
	protected static final String ERRKEY_0022 = "error.realpay.0022";
	protected static final String ERRKEY_AAAA = "error.realpay.AAAA";

	private static final HashMap errors;
	private static final HashMap errorKeys;
	
	static {
		errors = new HashMap();
		errors.put(ERRCODE_0000,ERRMSG_0000);
		errors.put(ERRCODE_9999,ERRMSG_9999);
		errors.put(ERRCODE_0001,ERRMSG_0001);
		errors.put(ERRCODE_0002,ERRMSG_0002);
		errors.put(ERRCODE_0003,ERRMSG_0003);
		errors.put(ERRCODE_0004,ERRMSG_0004);
		errors.put(ERRCODE_0005,ERRMSG_0005);
		errors.put(ERRCODE_0006,ERRMSG_0006);
		errors.put(ERRCODE_0007,ERRMSG_0007);
		errors.put(ERRCODE_0008,ERRMSG_0008);
		errors.put(ERRCODE_0009,ERRMSG_0009);
		errors.put(ERRCODE_0010,ERRMSG_0010);
		errors.put(ERRCODE_0011,ERRMSG_0011);
		errors.put(ERRCODE_0012,ERRMSG_0012);
		errors.put(ERRCODE_0013,ERRMSG_0013);
		errors.put(ERRCODE_0014,ERRMSG_0014);
		errors.put(ERRCODE_0015,ERRMSG_0015);
		errors.put(ERRCODE_0016,ERRMSG_0016);
		errors.put(ERRCODE_0017,ERRMSG_0017);
		errors.put(ERRCODE_0018,ERRMSG_0018);
		errors.put(ERRCODE_0019,ERRMSG_0019);
		errors.put(ERRCODE_0020,ERRMSG_0020);
		errors.put(ERRCODE_0021,ERRMSG_0021);
		errors.put(ERRCODE_0022,ERRMSG_0022);		
		errors.put(ERRCODE_AAAA,ERRMSG_AAAA);	
	}
	
	static {
		errorKeys = new HashMap();
		errorKeys.put(ERRCODE_0000,ERRKEY_0000);
		errorKeys.put(ERRCODE_9999,ERRKEY_9999);
		errorKeys.put(ERRCODE_0001,ERRKEY_0001);
		errorKeys.put(ERRCODE_0002,ERRKEY_0002);
		errorKeys.put(ERRCODE_0003,ERRKEY_0003);
		errorKeys.put(ERRCODE_0004,ERRKEY_0004);
		errorKeys.put(ERRCODE_0005,ERRKEY_0005);
		errorKeys.put(ERRCODE_0006,ERRKEY_0006);
		errorKeys.put(ERRCODE_0007,ERRKEY_0007);
		errorKeys.put(ERRCODE_0008,ERRKEY_0008);
		errorKeys.put(ERRCODE_0009,ERRKEY_0009);
		errorKeys.put(ERRCODE_0010,ERRKEY_0010);
		errorKeys.put(ERRCODE_0011,ERRKEY_0011);
		errorKeys.put(ERRCODE_0012,ERRKEY_0012);
		errorKeys.put(ERRCODE_0013,ERRKEY_0013);
		errorKeys.put(ERRCODE_0014,ERRKEY_0014);
		errorKeys.put(ERRCODE_0015,ERRKEY_0015);
		errorKeys.put(ERRCODE_0016,ERRKEY_0016);
		errorKeys.put(ERRCODE_0017,ERRKEY_0017);
		errorKeys.put(ERRCODE_0018,ERRKEY_0018);
		errorKeys.put(ERRCODE_0019,ERRKEY_0019);
		errorKeys.put(ERRCODE_0020,ERRKEY_0020);
		errorKeys.put(ERRCODE_0021,ERRKEY_0021);
		errorKeys.put(ERRCODE_0022,ERRKEY_0022);
		errorKeys.put(ERRCODE_AAAA,ERRKEY_AAAA);
	
	}

	/**
	 * 
	 * @param errorCode
	 * @return
	 */	
	public static String getTextMessage(String errorCode) {
		String response = null;
		
		response = (String) errors.get(errorCode);		
		if (response == null || response.trim().equals("")) {
			response = (String) errors.get(ERRCODE_AAAA);
		}
		
		return response;
	}

	/**
	 * 
	 * @param errorCode
	 * @return
	 */	
	public static String getKeyMessage(String errorCode) {
		String response = null;
		response = (String) errorKeys.get(errorCode);

		if (response == null || response.trim().equals("")) {
			response = (String) errorKeys.get(ERRCODE_AAAA);
		}
		
		return response;
	}
}
