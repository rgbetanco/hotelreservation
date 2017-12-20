/*
 * Created on Oct 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.init;

import java.util.Map;

import com.nicahost.common.exception.InitException;


/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IDaemon extends Runnable {
	
	public void init(Map params) throws InitException; 
}
