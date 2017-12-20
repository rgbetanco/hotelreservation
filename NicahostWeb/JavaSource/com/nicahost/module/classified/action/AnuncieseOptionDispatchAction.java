/*
 * Created on Feb 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AnuncieseOptionDispatchAction extends DispatchAction {
	
	public ActionForward sellerOnly(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
	  throws IOException, ServletException, Exception {

		ActionForward forward = null;
	
		ClassifiedService service = ClassifiedService.getInstance();		
		Collection categories = service.getCategoriesAsCollection();
		request.setAttribute("categories",categories);
		
				
		forward = mapping.findForward("Success1");
		
		return forward;
	}


	public ActionForward sellerOnline(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
		
		ActionForward forward = null;
		/*
		ActionMessages messages = new ActionMessages();
		ActionMessage newActionMessage = new ActionMessage("error.modulenotimplemented");		
		messages.add("GLOBAL_ERROR",newActionMessage);		
		saveErrors(request,messages);
		forward = mapping.findForward("Failure");
		*/
		HttpSession session = request.getSession(false);		
		ProfileBean bean = (ProfileBean) session.getAttribute("userProfile");
		
		if (bean != null) {
			if (GenericValidator.isBlankOrNull(bean.getSellerAccount())) {
				//Si no tiene cuenta de vendedor
				forward = mapping.findForward("NewSellerAccount");
				return forward;
			} else {
				//Sin tiene cuenta de vendedor
				forward = mapping.findForward("SellItem");
				return forward;
			}
		}
 
		forward = mapping.findForward("Success2");
		
		return forward;

	}

	public ActionForward sellerOnlineStore(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
			ActionForward forward = null;
		
			ActionMessages messages = new ActionMessages();
			ActionMessage newActionMessage = new ActionMessage("error.modulenotimplemented");
		
			messages.add("GLOBAL_ERROR",newActionMessage);	
		
			saveErrors(request,messages);

			forward = mapping.findForward("Failure");
		
			return forward;
	}	

	public ActionForward buyerOnly(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {

			ActionForward forward = null;
		
			ActionMessages messages = new ActionMessages();
			ActionMessage newActionMessage = new ActionMessage("error.modulenotimplemented");
		
			messages.add("GLOBAL_ERROR",newActionMessage);	
		
			saveErrors(request,messages);

			forward = mapping.findForward("Failure");
		
			return forward;
	}	

}
