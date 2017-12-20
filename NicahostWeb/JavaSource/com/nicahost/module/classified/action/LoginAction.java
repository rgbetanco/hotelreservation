/*
 * Created on Feb 22, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.form.SignInForm;
import com.nicahost.module.classified.service.ClassifiedService;
import com.nicahost.module.classified.session.ShoppingCart;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LoginAction extends ClasificadosBaseAction {

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
			SignInForm signForm = (SignInForm) form;

			HttpSession session = request.getSession(true);
			
			String email = signForm.getEmail();
			String password = signForm.getPassword();
			
			
			ClassifiedService service = ClassifiedService.getInstance();
		
			ProfileBean bean = service.authenticate(email,password);
		
			synchronized(session) {
				// Hay que matar la session y crear una nueva
				session.invalidate();
				session = request.getSession(true);				
				session.setAttribute(USERPROFILE,bean);
				session.setAttribute(USERNAME_COOKIE,bean.getUserName());
								
				setCookie(response,USERNAME_COOKIE,bean.getUserName());
				setCookie(response,EMAIL_COOKIE,bean.getEmail());
			}
			
			// Logica para cuando el evento viene del sign para vender			
			String nextview = signForm.getNextview();
			nextview = (nextview != null) ? nextview:"";
			if (nextview.equals("sell")) {
				
				if (GenericValidator.isBlankOrNull(bean.getSellerAccount()) || !bean.getSellerAccount().equalsIgnoreCase("true")) {
					//si no tiene cuenta de vendedor
					forward = mapping.findForward("NewSellerAccount"); 
				} else {
					// si tiene cuenta de vendedor
					forward = mapping.findForward("SellItem");
				}

				return forward;
			}			
			
			forward = mapping.findForward("Success");
			
		return forward;
	}

}
