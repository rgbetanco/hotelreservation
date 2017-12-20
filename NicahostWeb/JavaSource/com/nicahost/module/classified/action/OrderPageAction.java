package com.nicahost.module.classified.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;
import com.nicahost.module.classified.session.ShoppingCart;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OrderPageAction extends ClasificadosBaseAction {

	
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
		ShoppingCart cart;
		
		synchronized(session) {
			cart = (ShoppingCart) session.getValue(SHOPPING_CART);
			if (cart == null) {
				cart = new ShoppingCart();
				session.putValue(SHOPPING_CART,cart);
			}
			
			String itemId = request.getParameter("itemId");
			if (itemId != null) {
				String numItemsString = request.getParameter("numItems");
				if (numItemsString == null) {
					cart.addItem(itemId);
				} else {
					int numItems;
					try {
						numItems = Integer.parseInt(numItemsString);
					} catch (NumberFormatException nfe) {
						numItems = 1;
					}
					
					cart.setNumOrdered(itemId,numItems);
				}
			} //end if
		} //end synchronized
		
		Collection itemsOrdered = cart.getItemsOrdered();
		session.setAttribute("itemsOrdered",itemsOrdered);
		
		String checkout = request.getParameter("checkout");
		checkout = (checkout != null) ? checkout: "";
		
		
		forward = mapping.findForward("Success");
		
		if (checkout.equals("true")) {
			forward = mapping.findForward("Success1");
			request.setAttribute("checkout","true");
		}
			
			
		
		return forward;
	}

}
