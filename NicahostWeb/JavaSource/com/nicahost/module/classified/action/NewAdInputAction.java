package com.nicahost.module.classified.action;

import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class NewAdInputAction extends ClasificadosBaseAction {

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
		
		Vector navigationItems = new Vector();
		MessageResources resources = (MessageResources)request.getAttribute(Globals.MESSAGES_KEY);
		//que de esta forma no se puede leer de varios archivos de resources, por tanto
		
		//en el mismo archivo de resources se especifican llaves completadas con el locale.
		navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav1"), null));			
		navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav2"), null));
		headerForm.setNavigationItems(navigationItems);
		
		ClassifiedService service = ClassifiedService.getInstance();
		
		Collection categories = service.getCategories();
		
		request.setAttribute("categories",categories);
		
		forward = mapping.findForward("Success");
		
		log.info(forward.getPath());
		
		return forward;
	}

}
