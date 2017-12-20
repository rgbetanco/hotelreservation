/*
 * Created on Jul 8, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.config.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nicahost.common.util.BeanPropertyComparator;
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.classified.bean.CountryBean;
import com.nicahost.module.classified.bean.RegionBean;
import com.nicahost.module.classified.bean.StateBean;
import com.nicahost.module.classified.dao.ClassifiedDAO;
import com.nicahost.module.classified.dto.CategoryDTO;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public final class ClasificadosInitParamDAO {

	static Logger log = Logger.getLogger(ClasificadosInitParamDAO.class);
	
	private static ClasificadosInitParamDAO hotelReserveInit = null;
	private static Map categories = null;
	private static ArrayList banks = null;	
	private static Collection shippingLocations = null;
	private static final String SORT_KEY = "catDesc";
	private static Collection picks = null;

	static  {
		loadCategories();
		loadBanks();
		
		loadShippingLoations();
	}
	
	private ClasificadosInitParamDAO() {/*Constructor vacio*/}
	

	public static ClasificadosInitParamDAO getInstance() {
		if (null == hotelReserveInit ) {
			hotelReserveInit = new ClasificadosInitParamDAO();
		}		
		return hotelReserveInit;
	}

	public Map getCategories() {
		return categories;
	}
	
	public String getCategoryName(String id) {
		String res = null;
		if (categories.containsKey(id)) {
			CategoryDTO dto = (CategoryDTO) categories.get(id);
			res = dto.getCatLabel();
		}
		
		return res;
	}
	
	public Collection getCategoriesAsCollection() {
		return sortCategories(null);
	}
	
	public synchronized Collection sortCategories(String sortIndex) {
		Object[] values = categories.values().toArray();
		List res = Arrays.asList(values);
		BeanPropertyComparator bpc;
		if (sortIndex != null) {
			bpc = new BeanPropertyComparator(sortIndex);						
		} else {
			bpc = new BeanPropertyComparator(SORT_KEY);
		}
		Collections.sort(res,bpc);
		
		return res;
	}
	
	public Collection getCategoriesAsOptions() {
		ArrayList list = new ArrayList();
		Object[] values = categories.values().toArray();
		List res = Arrays.asList(values);		
		for (Iterator iter = res.iterator(); iter.hasNext();) {
			CategoryDTO element = (CategoryDTO) iter.next();
			list.add(new OptionView(element.getCatDesc(),element.getCatId()));
		}
		Collections.sort(list);
		
		return list;
	}
	
	public Collection getNicaraguaBanks() {
		return banks;		
	}
	

	
	public Collection getShippingLocations() {
		return shippingLocations;
	}
	
	public CountryBean getShippingLocations(String countryName) {
		CountryBean bean = null;
		for (Iterator iter = shippingLocations.iterator(); iter.hasNext();) {
			CountryBean tempBean = (CountryBean) iter.next();
			if (tempBean.getCountryName().equals(countryName))
				bean = tempBean;
				break;				
		}

		return bean;
	}
	
	public Collection getStatesForCountry(String countryName) {
		List states = new ArrayList();
		CountryBean element;
		for (Iterator iter = shippingLocations.iterator(); iter.hasNext();) {
			element = (CountryBean) iter.next();
			if (element.getCountryName().equals(countryName)) {
				states = element.getStates();
				break;	
			}
		}		
		return states;
	}
	
	public Collection getRegionsForCountry(String countryName) {
		List regions = new ArrayList();
		CountryBean element;
		for (Iterator iter = shippingLocations.iterator(); iter.hasNext();) {
			element = (CountryBean) iter.next();
			if (element.getCountryName().equals(countryName)) {
				regions = element.getRegions();
				break;	
			}
		}				
		return regions;
	}
	
	public Collection getStatesForRegion(String countryName, String regionName) {
		List states = new ArrayList();
		List tempRegions = (ArrayList) getRegionsForCountry(countryName);
		for (Iterator iterator = tempRegions.iterator();iterator.hasNext();	) {
			RegionBean ele = (RegionBean) iterator.next();
			if (ele.getRegionName().equals(regionName)) {
				states = ele.getStates();
				break;
			}
		}

		return states;
	}
	
	public Collection getRegionsForState(String countryName, String stateName) {
		List regions = new ArrayList();
		List statesForCountry = (ArrayList) getStatesForCountry(countryName);
		for (Iterator iter = statesForCountry.iterator(); iter.hasNext();) {
			StateBean element = (StateBean) iter.next();
			if (element.getStateName().equals(stateName)) {
				regions = element.getRegions();
				break;
			}			
		}
		
		return regions;
	}
	
	public Collection getPicks() {
		return picks;
	}
	
	public void setPicks(Collection in_picks) {
		picks = in_picks;
	}
	
	public synchronized static void loadCategories() {
		log.debug("Loading categories...");
		ClassifiedDAO dao = new ClassifiedDAO();
		
		try {
			categories = dao.getCategories();	
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(), ex);	
		}		
	}
	
	private synchronized static void loadBanks() {
		log.debug("Loading banks...");
		ClassifiedDAO dao = new ClassifiedDAO();
		
		try {
			banks = (ArrayList) dao.getNicaraguaBanks();
			Collections.sort(banks);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(),ex);
		}
	}
	

	
	private synchronized static void loadShippingLoations() {
		log.debug("Loading shipping locations...");
		ClassifiedDAO dao = new ClassifiedDAO();
		try {
			shippingLocations = dao.getShippingLocations();			
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(),ex);
		}		
		
	}

}
