package com.nicahost.framework.common.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ShowErrorAction extends BaseAction {

	/**
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse, HeaderForm, FooterForm)
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
		String linkFilterReturn = null;
		Vector navigationItems = null;
		
		
		navigationItems = (Vector) request.getAttribute("navigationItems");
		if (navigationItems == null || navigationItems.size() == 0) {
			navigationItems = new Vector();
			navigationItems.addElement(new NavigationItem("Inicio", null));
			navigationItems.addElement(new NavigationItem("Mensaje", null));
		}

		headerForm.setNavigationItems(navigationItems);		
		
		
		forward = mapping.findForward("Success");
			
		return forward;
	}

}
