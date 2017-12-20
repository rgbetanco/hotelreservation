/*
 * Created on Feb 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.bean.AddressBean;
import com.nicahost.module.classified.bean.PaymentInfoBean;
import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.service.ClassifiedService;
import com.nicahost.module.classified.session.ShoppingCart;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FastCheckoutLoginAction extends ClasificadosBaseAction {

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
			DynaValidatorActionForm checkoutForm = (DynaValidatorActionForm) form;
			HttpSession session = request.getSession(false);
			
			ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingCart");
			
			Map map = checkoutForm.getMap();
			String email = (String) map.get("email");
			String password = (String) map.get("password");
			
			
			ClassifiedService service = ClassifiedService.getInstance();
		
			ProfileBean bean = service.getProfile(email,null,password);
		
			synchronized(session) {
				session.setAttribute(USERPROFILE,bean);
				setCookie(response,USERNAME_COOKIE,bean.getUserName());
				setCookie(response,EMAIL_COOKIE,bean.getEmail());
				//Iniciar un checkoutForm totalmente vacio
				BeanUtils.copyProperties(checkoutForm, new AddressBean());
				BeanUtils.copyProperties(checkoutForm, new PaymentInfoBean());				
							
			}
			
			for (Iterator iter = bean.getShippingAddresses().iterator(); iter.hasNext();) {
					AddressBean element = (AddressBean) iter.next();
					//map.put("address",element.getAddress());
					BeanUtils.copyProperties(checkoutForm,element);				
				}
			
			for (Iterator iter = bean.getCreditCards().iterator(); iter.hasNext();) {
				PaymentInfoBean element = (PaymentInfoBean) iter.next();
				BeanUtils.copyProperties(checkoutForm,element);
			}

			if (cart != null) {
				if (cart.getItemsOrdered().size() < 1) {
					forward = mapping.findForward("FailureCartEmpty");
					return forward;
				}
			}
			
			if (bean.getShippingAddresses().isEmpty()) {		
				forward = mapping.findForward("FailureShippingAddress");
				return forward;					
			}
			
			if (bean.getCreditCards().isEmpty()) {
				forward = mapping.findForward("FailurePaymentInfo");
				return forward;
			}
							
			forward = mapping.findForward("Success");
						
			return forward;
	}

}
