/*
 * Created on Apr 21, 2006
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
public class RegionBean implements Serializable, Comparable {
	private String regionId;
	private String regionName;
	private List states;
	
	
	public RegionBean() {
		this.regionId = "";
		this.regionName = "";
		this.states = new ArrayList();
	}
	
	public RegionBean(String _regionId, String _regionName) {
		this.regionId = _regionId;
		this.regionName = _regionName;
		this.states = new ArrayList();
	}
	
	public void addState(String stateId, String stateName) {
		getStates().add(new StateBean(stateId,stateName));
	}
	
	public void addState(StateBean stateBean) {
		getStates().add(stateBean);
	}
	
	/**
	 * @return
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @return
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @return
	 */
	public List getStates() {
		return states;
	}

	/**
	 * @param string
	 */
	public void setRegionId(String string) {
		regionId = string;
	}

	/**
	 * @param string
	 */
	public void setRegionName(String string) {
		regionName = string;
	}

	/**
	 * @param list
	 */
	public void setStates(List list) {
		states = list;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		RegionBean bean = (RegionBean) arg0;
		
		return this.getRegionName().compareTo(bean.getRegionName());
	}

}
