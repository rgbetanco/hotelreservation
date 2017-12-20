/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.action;

import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.NavigationItem;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowGalleryAction extends BaseAction {

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
		
			Vector navigationItems = new Vector();
			MessageResources resources = (MessageResources)request.getAttribute(Globals.MESSAGES_KEY);
			//que de esta forma no se puede leer de varios archivos de resources, por tanto
		
			//en el mismo archivo de resources se especifican llaves completadas con el locale.
			navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav1"), null));			
			navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav3"), null));
			headerForm.setNavigationItems(navigationItems);		
			
			String id = request.getParameter("idParm");
			HotelReserveService service = HotelReserveService.getInstance();
	
				Collection photoGallery = service.getPhotoGallery(id);
				request.setAttribute("photoGallery", photoGallery);
	
			
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
