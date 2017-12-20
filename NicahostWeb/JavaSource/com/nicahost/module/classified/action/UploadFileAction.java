/*
 * Created on Feb 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.DynaValidatorForm;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UploadFileAction extends BaseAction {

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
			
		DynaValidatorForm anuncieseForm = (DynaValidatorForm) form;
		Map map = anuncieseForm.getMap();
		ClassifiedService service = ClassifiedService.getInstance();
		
		String catId = (String) map.get("category");

		FormFile myFile;	
		String newFileName;		
		Object element;  
		String ref;
		
		myFile = (FormFile) map.get("myFile");
		newFileName = service.uploadFile(myFile);
		map.put("myFileName",newFileName);
		
/*		Collection l = (Collection) map.values();
				
		for (Iterator iter = l.iterator(); iter.hasNext();) {
			element = (Object) iter.next();
			if (element instanceof FormFile) {
				myFile = (FormFile) element;
				FormFile mFile  = (FormFile) element;
				newFileName = service.uploadFile(mFile);
				ref = myFile.getFileName().concat("Name");
				map.put(ref,newFileName);
			}			
		}
			
*/		
		
		request.setAttribute("imgPath", ClasificadosInitParamBean.getInstance().getValue(ClasificadosInitParamBean.TEMP_IMG));
		request.setAttribute("categoryName",service.getCategoryName(catId));

	  return mapping.findForward("Success");	}

}
