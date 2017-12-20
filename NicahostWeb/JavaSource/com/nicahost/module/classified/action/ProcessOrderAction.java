/*
 * Created on Feb 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.validator.DynaValidatorActionForm;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProcessOrderAction extends LookupDispatchAction {
	private final String USERPROFILE = "userProfile";

	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("button.processorder", "processOrder");
		map.put("button.fastcheckout.login","doLogin");
		return map;
	}

	public ActionForward processOrder(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		
		DynaValidatorActionForm checkoutForm = (DynaValidatorActionForm) form;
		
		Map map = checkoutForm.getMap();
		
		
		forward = mapping.findForward("Success");
		
		return forward;
	}
	
	public ActionForward editShippingAddress(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception {
			
		ActionForward forward;
		
		forward = mapping.findForward("ToShipping");
		
		return forward;
		}

	public ActionForward editPaymentInfo(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		ActionForward forward;
		forward = mapping.findForward("ToPaymentInfo");
		
		return forward;
		}
	
}
