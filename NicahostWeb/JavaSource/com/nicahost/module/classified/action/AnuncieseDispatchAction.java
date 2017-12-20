/*
 * Created on Feb 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.module.classified.bean.AdvertisementBean;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AnuncieseDispatchAction extends DispatchAction {
	
	public ActionForward add(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
	  throws IOException, ServletException, Exception {

		ActionForward forward = null;
		DynaValidatorForm adForm = (DynaValidatorForm) form;
		AdvertisementBean adBean = new AdvertisementBean();
		Map map = adForm.getMap();
		String price = (String) map.get("price");
		try {
			double t = Double.parseDouble(price);
			adBean.setCost(t);
		} catch(Exception ex) {
			ex.printStackTrace();	
		}		
		System.out.println("entrando al anunciesedispatchaction del action");
		BeanUtils.copyProperties(adBean,adForm);
		ClassifiedService service = ClassifiedService.getInstance();	
		boolean success = service.insertAdvertisement(adBean);
		if (!success)
			throw new BaseException("error.failure");

		forward = mapping.findForward("Success2");
		return forward;	
	}


	public ActionForward delete(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {

		DynaValidatorForm anuncieseForm = (DynaValidatorForm) form;
		Map map = anuncieseForm.getMap();
		String myFile = (String) map.get("fileName");
		
		ClassifiedService service = ClassifiedService.getInstance();
		service.deleteUploadedFile(myFile);
	  
	  return mapping.findForward("Success3");
	}

	

}
