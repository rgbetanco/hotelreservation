/*
 * Created on Mar 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorActionForm;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.bean.BankAccountBean;
import com.nicahost.module.classified.bean.PaymentInfoBean;
import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.service.ClassifiedMailService;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NewSellerAccountAction extends BaseAction {

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
		DynaValidatorActionForm sellerForm = (DynaValidatorActionForm) form;		
		HttpSession session = request.getSession(false);
		
		ProfileBean profileBean = (ProfileBean) session.getAttribute("userProfile");
		if (profileBean == null) { //significa que la session expiro
			ActionMessages messages = new ActionMessages();
			ActionMessage newActionMessage = new ActionMessage("error.sessiontimedout");			
			messages.add("GLOBAL_ERROR",newActionMessage);
			saveErrors(request,messages);
			forward = mapping.findForward("SessionTimedOut");
			return forward;
		}
		
		PaymentInfoBean creditcardBean = new PaymentInfoBean();
		BankAccountBean bankaccountBean = new BankAccountBean();
		
		Map map = sellerForm.getMap();
		
		
		BeanUtils.copyProperties(creditcardBean,sellerForm);
		BeanUtils.copyProperties(bankaccountBean,sellerForm);
		String sellingFee = (String) map.get("sellingFee");
		
		ClassifiedService service = ClassifiedService.getInstance();
		
		if (service.addNewSellerAccount(creditcardBean,bankaccountBean,profileBean,sellingFee)) {
			ClassifiedMailService mailService = ClassifiedMailService.getInstance();
			mailService.sendMessageNewAccountSeller(profileBean.getEmail());	
		}
		
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
