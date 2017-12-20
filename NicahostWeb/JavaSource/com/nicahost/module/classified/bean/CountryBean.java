/*
 * Created on Apr 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CountryBean implements Serializable, Comparable {
	private String countryId;
	private String countryName;
	private List states;
	private List regions;
	
	public CountryBean() {
		countryId = "";
		countryName = "";
		states = new ArrayList();
		regions = new ArrayList();
	}
	
	public CountryBean(String in_countryId, String in_countryName) {
		countryId = in_countryId;
		countryName = in_countryName;
		states = new ArrayList();
		regions = new ArrayList();
	}
	
	public void addState(String stateid, String statename) {
		this.states.add(new StateBean(stateid,statename));		
	}
	
	public void addState(StateBean stateBean) {
		this.states.add(stateBean);
	}
	
	public void addRegion(String regionId, String regionName) {
		this.regions.add(new RegionBean(regionId, regionName));
	}
	
	public void addRegion(RegionBean regionBean) {
		this.regions.add(regionBean);
	}
	
	public RegionBean getRegion(RegionBean regionBean) {
		RegionBean element = null;
		for (Iterator iter = regions.iterator(); iter.hasNext();) {
			element = (RegionBean) iter.next();
			if (regionBean.equals(regionBean)) {
				break;		
			}
		}
	
		return element;
	}
	
	/**
	 * @return
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * @return
	 */
	public String getCountryName() {
		return countryName;
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
	public void setCountryId(String string) {
		countryId = string;
	}

	/**
	 * @param string
	 */
	public void setCountryName(String string) {
		countryName = string;
	}

	/**
	 * @param list
	 */
	public void setStates(List list) {
		states = list;
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
		CountryBean bean = (CountryBean) arg0;
		
		return this.countryName.compareTo(bean.getCountryName());
	}

	

}
