/*
 * Created on Jun 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LogoutAction extends ClasificadosBaseAction {

	/* (non-Javadoc)
	 * @see com.nicahost.module.classified.action.ClasificadosBaseAction#runAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.nicahost.framework.common.form.HeaderForm, com.nicahost.framework.common.form.FooterForm)
	 */
	public ActionForward runAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {
		
		ActionForward forward = null;
		HttpSession session = request.getSession(true);

			synchronized(session) {
				// Hay que matar la session
				session.invalidate();
								
				setCookie(response,USERNAME_COOKIE,"");
				setCookie(response,EMAIL_COOKIE,"");
			}		
		
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
