package com.nicahost.module.classified.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
public class GetCountryAction extends BaseAction {

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
		
		ClassifiedService service = ClassifiedService.getInstance();		
		Collection nicaraguaStates = service.getNicaraguaStates();
		Collection worldwide = service.getWorldWideStates();
		Collection location = service.getShippingLocations();
		Collection nicaRegions = service.getNicaraguaRegions();
		Collection wwRegions = service.getWorldWideRegions();
		
		request.setAttribute("nicaraguaStates",nicaraguaStates);
		request.setAttribute("nicaraguaRegions",nicaRegions);
		request.setAttribute("worldwideStates",worldwide);
		request.setAttribute("worldwideRegions",wwRegions);
		request.setAttribute("shippingLocations",location);
		
				
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
