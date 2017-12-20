/*
 * Created on Jul 5, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;
import java.text.SimpleDateFormat;
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
public class ShowConfirmedAnulledAction extends AdminBaseAction {

	private long defaultInitDate = 1;
	private long defaultFinDate = 999999999;
	
	public ActionForward adminExecuteAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {
		
		ActionForward forward = null;
		
		String d = "01/01/1979";
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date d79 = sdf.parse(d);
		defaultInitDate = d79.getTime();
		defaultFinDate = now.getTime();

		HotelAdminService service = HotelAdminService.getInstance();

		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);

		Collection colview = service.getConfirmedAnulled(defaultInitDate, defaultFinDate);
		
		request.setAttribute("ConfirmedAnulled", colview);

		return forward;
	}
}
