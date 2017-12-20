/*
 * Created on Jul 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.framework.common.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.nicahost.common.config.bean.CardParametersBean;
import com.nicahost.common.config.bean.InitParameterArrayBean;
import com.nicahost.common.config.bean.InitParameterBean;
import com.nicahost.framework.common.view.OptionView;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CommonService {

	private static CommonService commonService = null;	

	private CommonService() {/*Constructor vacio*/}
	
	/**
	 * Implementacion del metodo getInstance() para obtener una
	 * instancia singleton
	 * @return HotelReserveService
	 */
	public static CommonService getInstance() {
		if (null == commonService) {
			commonService = new CommonService();
		}
		
		return commonService;
	}


	/**
	 * Returns the years in which a credit card can expire
	 *
	 * @return The current year, plus the next four years
	 */
	public Collection getCardExpirationYears() {
		ArrayList years = null;
		GregorianCalendar today = null;
		int currentYear = -1;

		years = new ArrayList(7);
		today = new GregorianCalendar();
		currentYear = today.get(GregorianCalendar.YEAR);
		String year;
		for (int i = 0; i < 7; i++) {
			year = Integer.toString(currentYear + i);
			years.add(new OptionView(year,year));
		}

		Collections.sort(years);
		return years;
	}


	/**
	 * Gets all the possible months in a collection
	 *
	 * @return All months
	 */
	public Collection getMonths() {
		ArrayList months = null;

		months = new ArrayList(12);
		months.add(new OptionView("Enero", "01"));
		months.add(new OptionView("Febrero", "02"));
		months.add(new OptionView("Marzo", "03"));
		months.add(new OptionView("Abril", "04"));
		months.add(new OptionView("Mayo", "05"));
		months.add(new OptionView("Junio", "06"));
		months.add(new OptionView("Julio", "07"));
		months.add(new OptionView("Agosto", "08"));
		months.add(new OptionView("Septiembre", "09"));
		months.add(new OptionView("Octubre", "10"));
		months.add(new OptionView("Noviembre", "11"));
		months.add(new OptionView("Diciembre", "12"));

		return months;
	}
	
	public Collection getCardTypes() {
		ArrayList result = new ArrayList();
		InitParameterArrayBean cardTypes = null;
		cardTypes = CardParametersBean.getInstance().getList();
		
		for (Iterator iter = cardTypes.iterator(); iter.hasNext();) {
			InitParameterBean element = (InitParameterBean) iter.next();
			
			result.add(new OptionView(element.getName(),element.getValue()));		
		}
		
		return result;
	}
}
