/*
 * Created on Sep 25, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FilterConfirmedAnnulledAction extends AdminBaseAction {
	
	private HotelAdminService adminService = HotelAdminService.getInstance();

	public ActionForward adminExecuteAction(
				ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response,
				HeaderForm headerForm,
				FooterForm footerForm)
				throws Exception {
				
				ActionForward forward = null;
				
				String dateIni = request.getParameter("initDate");
				String dateFin = request.getParameter("finDate");
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
				sdf.setCalendar(Calendar.getInstance());
				Date initDate = sdf.parse(dateIni);
				Date finDate = sdf.parse(dateFin);
				
				long millSecDateIni = initDate.getTime();
				long millSecDateFin = finDate.getTime();
				
				Collection colview = adminService.getConfirmedAnulled(millSecDateIni, millSecDateFin);
		
				request.setAttribute("ConfirmedAnulled", colview);
				
				forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
				
				return forward;
				
		}
}
