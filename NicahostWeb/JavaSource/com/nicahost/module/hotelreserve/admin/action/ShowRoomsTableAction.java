/*
 * Created on Jul 22, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.GeneralConstants;
import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.hotelreserve.admin.service.HotelAdminService;
import com.nicahost.module.hotelreserve.service.HotelReserveService;

/**
 * @author rgbetanco
 * This method should return a view to put on the jsp for changes
 * with this the user will be able to edit the table freely
 */

public class ShowRoomsTableAction extends AdminBaseAction{
	
	public ActionForward adminExecuteAction(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response,
			HeaderForm headerForm,
			FooterForm footerForm)
			throws Exception {

			ActionForward forward = null;
			
			HotelAdminService service = HotelAdminService.getInstance();
			HotelReserveService service1 = HotelReserveService.getInstance();
			
			forward = mapping.findForward(GeneralConstants.SUCCESS_KEY);
			
			Collection roomsToShow = service.getRooms();
			Collection roomTypes = service1.getRoomTypes();
			
			request.setAttribute("rooms",roomsToShow);
			request.setAttribute("roomTypes",roomTypes);
					
			return forward;
			
			}

}
