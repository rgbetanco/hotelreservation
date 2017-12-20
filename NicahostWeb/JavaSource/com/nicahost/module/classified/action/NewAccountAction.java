/*
 * Created on Feb 9, 2006
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
import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.form.NewAccountForm;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NewAccountAction extends ClasificadosBaseAction {

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
		HttpSession session = request.getSession(false);

		NewAccountForm accountForm = (NewAccountForm) form;
		
		//Aqui debe ir la logica para agregar el nuevo usuario a la bdatos
		ClassifiedService service = ClassifiedService.getInstance();
		
		ProfileBean bean = service.addNewUser(accountForm.getEmail(), accountForm.getName(), accountForm.getPassword());
		
		synchronized(session) {
			// Hay que matar la session y crear una nueva
			session.invalidate();
			session = request.getSession(true);				
			session.setAttribute(USERPROFILE,bean);
			session.setAttribute(USERNAME_COOKIE,bean.getUserName());
								
			setCookie(response,USERNAME_COOKIE,bean.getUserName());
			setCookie(response,EMAIL_COOKIE,bean.getEmail());
		}
		
		String var = accountForm.getCheckout();
		var = (var != null) ? var:"";
		if (var.equals("true")) {
			forward = mapping.findForward("ToShippingAddress");
			return forward;
		}
		
		String nextview = accountForm.getNextview();
		nextview = (nextview != null) ? nextview:"";
		if (nextview.equals("newselleraccount")) {
			forward = mapping.findForward("NewSellerAccount");
			return forward;
		}
		
		forward = mapping.findForward("Success");
		
		
		return forward;
	}

}
