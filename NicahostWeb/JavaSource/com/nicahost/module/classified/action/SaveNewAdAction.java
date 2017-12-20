package com.nicahost.module.classified.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.bean.AdvertisementBean;
import com.nicahost.module.classified.form.NewAdForm;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class SaveNewAdAction extends BaseAction {

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
		

		
		NewAdForm adForm = (NewAdForm) form;
		
		AdvertisementBean adBean = new AdvertisementBean();
		
		BeanUtils.copyProperties(adBean,adForm);
		try {
			double t = Double.parseDouble(adForm.getPrice());
			adBean.setCost(t);
		} catch(Exception ex) {
			
		}
		
		ClassifiedService service = ClassifiedService.getInstance();	
		
		boolean success = service.insertAdvertisement(adBean);
		
		if (!success)
			throw new BaseException("error.failure");
		
		
		
		forward = mapping.findForward("Success");

		return forward;
	}

}
