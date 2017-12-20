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
import com.nicahost.module.classified.bean.AdvertisementBean;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;
import com.nicahost.module.classified.form.SearchForm;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class SearchAction extends BaseAction {

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
			SearchForm searchForm = (SearchForm) form;
			String criteriaParam = searchForm.getCriteria();
			
			ClassifiedService service = ClassifiedService.getInstance();
			
			AdvertisementBean adBean = service.getItem(criteriaParam);
		
			Collection categories = service.getCategoriesAsCollection();				
			request.setAttribute("categories",categories);
				
			String imgPath = ClasificadosInitParamBean.getInstance().getValue(ClasificadosInitParamBean.TEMP_IMG);
			request.setAttribute("imgPath", imgPath);
			request.setAttribute("adBean",adBean);

			forward = mapping.findForward("Success");						
		
		return forward;
	}

}
