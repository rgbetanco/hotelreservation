/*
 * Created on Oct 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DaemonBean implements Serializable {
	
	private String daemonName;
	private String daemonClass;
	private String priority;
	private String time;
	private String start;
	
	private Map initParameters;
	
	public DaemonBean() {
		initParameters = new HashMap();
	}

	

	/**
	 * @return
	 */
	public String getDaemonClass() {
		return daemonClass;
	}

	/**
	 * @return
	 */
	public String getDaemonName() {
		return daemonName;
	}

	/**
	 * @param string
	 */
	public void setDaemonClass(String string) {
		daemonClass = string;
	}

	/**
	 * @param string
	 */
	public void setDaemonName(String string) {
		daemonName = string;
	}

	/**
	 * @return
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @return
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param string
	 */
	public void setPriority(String string) {
		priority = string;
	}

	/**
	 * @param string
	 */
	public void setTime(String string) {
		time = string;
	}


	/**
	 * @return
	 */
	public Map getInitParameters() {
		return initParameters;
	}

	/**
	 * @param map
	 */
	public void setInitParameters(Map map) {
		initParameters = map;
	}


	/**
	 * @return
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param string
	 */
	public void setStart(String string) {
		start = string;
	}

	public boolean loadOnBoot() { 
		boolean res = Boolean.valueOf(getStart()).booleanValue(); 
		return res;
	}
}
