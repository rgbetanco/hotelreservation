package com.nicahost.module.classified.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class GetCategoryAction extends ClasificadosBaseAction {

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
		
		ClassifiedService service = ClassifiedService.getInstance();		
		Collection categories = service.getCategoriesAsCollection();
		Collection picks = service.getPicks();

		
		request.setAttribute("categories",categories);
		request.setAttribute("picks",picks);
		String imgPath = ClasificadosInitParamBean.getInstance().getValue(ClasificadosInitParamBean.TEMP_IMG);
		request.setAttribute("imgPath", imgPath);
				
		forward = mapping.findForward("Success");
		
		return forward;
	}

}
