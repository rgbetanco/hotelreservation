/*
 * Created on Apr 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class StateBean implements Serializable, Comparable {
	private String stateId;
	private String stateName;
	private List regions;
	
	public StateBean() {
		this.stateName = "";
		this.stateId = "";
		this.regions = new ArrayList();
	}
	
	public StateBean(String in_stateid, String in_stateName) {
		this.stateName = in_stateName;
		this.stateId = in_stateid;
		this.regions = new ArrayList();
	}
	
	public void addRegion(String regionId, String regionName) {
		getRegions().add(new RegionBean(regionId,regionName));
	}
	
	public void addRegion(RegionBean regionBean) {
		getRegions().add(regionBean);
	}
	
	
	/**
	 * @return
	 */
	public String getStateId() {
		return stateId;
	}

	/**
	 * @return
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param string
	 */
	public void setStateId(String string) {
		stateId = string;
	}

	/**
	 * @param string
	 */
	public void setStateName(String string) {
		stateName = string;
	}

	/**
	 * @return
	 */
	public List getRegions() {
		return regions;
	}

	/**
	 * @param list
	 */
	public void setRegions(List list) {
		regions = list;
	}

/* (non-Javadoc)
 * @see java.lang.Comparable#compareTo(java.lang.Object)
 */
	public int compareTo(Object arg0) {
		StateBean bean = (StateBean) arg0;
		return this.stateName.compareTo(bean.getStateName());
	}

}
