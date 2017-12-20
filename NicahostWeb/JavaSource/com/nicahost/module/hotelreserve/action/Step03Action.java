/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.form.ReserveForm;
import com.nicahost.module.hotelreserve.helper.ReserveSession;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Step03Action extends BaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;
		//inicializacion de objetos session
		HttpSession httpSession = null;
		ReserveSession reserveSession = null;			
		httpSession = request.getSession();
		reserveSession = (ReserveSession) httpSession.getAttribute("reserveSession");
		
		//Vector de navegacion	
		Vector navigationItems = new Vector();
		MessageResources resources = (MessageResources) request.getAttribute(Globals.MESSAGES_KEY);
		navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav1"), null));
		navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav3"), null));
		headerForm.setNavigationItems(navigationItems);

		//Recuperacion de datos del request
/*		Step03Form step03Form = (Step03Form) form;
		String roomTypeId = step03Form.getRoomType();
		String initDate = step03Form.getInitDate();
		String endDate = step03Form.getEndDate();		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", getLocale(request));
		Calendar initDateCal = new GregorianCalendar();
		Calendar endDateCal = new GregorianCalendar();
		initDateCal.setTime(dateFormat.parse(step03Form.getInitDate()));
		endDateCal.setTime(dateFormat.parse(step03Form.getEndDate()));
*/		
		
		
		//Chele aqui esta para que te divirtas jijijijiji		
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
