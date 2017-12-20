package com.nicahost.module.classified.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.form.ForgotPwdForm;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ForgotPasswordAction extends ClasificadosBaseAction {

	/**
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse, HeaderForm, FooterForm)
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
		ForgotPwdForm pwdForm = (ForgotPwdForm) form;
		
		
		ClassifiedService service = ClassifiedService.getInstance();		
		
		service.forgotPassword(pwdForm.getEmail());
				
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
