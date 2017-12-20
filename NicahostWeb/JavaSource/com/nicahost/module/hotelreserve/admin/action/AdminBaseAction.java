/*
 * Created on Jul 24, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sun.misc.BASE64Decoder;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AdminBaseAction extends BaseAction {
	protected String user = null;
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
			HotelAdminService service = HotelAdminService.getInstance();
			String authorization = request.getHeader("Authorization");
			
		if (authorization == null) {
			askForPassword(response);
		} else {
			
			String userInfo = authorization.substring(6).trim();
			user = null;
			String password = null;
			BASE64Decoder decoder = new BASE64Decoder();

			String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
			int index = nameAndPassword.indexOf(":");
			user = nameAndPassword.substring(0, index);
			password = nameAndPassword.substring(index + 1);

			if (service.getAccessibility(user, password)) {
				forward = this.adminExecuteAction(mapping,form,request, response, headerForm, footerForm);
			} else {
				askForPassword(response);
			}
		}

		return forward;
		}
		private void askForPassword(HttpServletResponse response) {
			response.setStatus(response.SC_UNAUTHORIZED);
			response.setHeader(
				"WWW-Authenticate",
				"BASIC realm=\"Priviledged-few\"");
		}

		public abstract ActionForward adminExecuteAction(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response,
			HeaderForm headerForm,
			FooterForm footerForm)
			throws Exception;
	
}