/*
 * Created on Jul 6, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.dto.AnnulledDTO;
import com.nicahost.module.hotelreserve.admin.dto.ConfirmedDTO;
import com.nicahost.module.hotelreserve.admin.dto.NotConfirmed;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class commitChangesAction extends AdminBaseAction {

	private HotelAdminService adminService = HotelAdminService.getInstance();

	public ActionForward adminExecuteAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;
		
		int confirmation;

		ArrayList confirmedArray = new ArrayList();
		ArrayList annulledArray = new ArrayList();
		ArrayList notConfirmedArray = new ArrayList();

		String idsRemote[] = request.getParameterValues("idRemote");
		String idRemote;
		for (int i = 0; i < idsRemote.length; i++) {
			idRemote = idsRemote[i];
			
			try {
			
			confirmation = Integer.parseInt(request.getParameter("CBconfirmed"+idRemote));
			
			}catch(NumberFormatException nx){
				
				confirmation = 2;
			}
			if (confirmation==0) {
				ConfirmedDTO confirmedDTO = new ConfirmedDTO();
				confirmedDTO.setId(Integer.parseInt(idRemote));
				confirmedArray.add(confirmedDTO);
			}
					
			if (confirmation==1) {
				AnnulledDTO annulledDTO = new AnnulledDTO();
				annulledDTO.setId(Integer.parseInt(idRemote));
				annulledArray.add(annulledDTO);

			} 
			
			if(confirmation == 2){
				NotConfirmed notConfirmedDTO = new NotConfirmed();
				notConfirmedDTO.setId(confirmation);
				notConfirmedArray.add(notConfirmedDTO);
			}
			
		}
		String userLocal = user;
		adminService.commitChanges(annulledArray, confirmedArray, user);
		
		request.setAttribute("ConfirmedAttributes", confirmedArray);
		request.setAttribute("AnnulledAttributes", annulledArray);
		request.setAttribute("notConfirmedAttributes", notConfirmedArray);
		
		forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
		
		return forward;
	}

}
