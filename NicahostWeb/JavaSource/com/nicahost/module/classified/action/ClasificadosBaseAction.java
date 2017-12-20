/*
 * Created on Feb 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.framework.common.action.BaseAction;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.exception.ChangePasswordException;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class ClasificadosBaseAction extends BaseAction {
	private static int COOKIE_TIME_TO_LIVE = 60*60*24*365; // one year default
	protected static final String USERNAME_COOKIE = "userName";
	protected static final String EMAIL_COOKIE = "userEmail";
	protected static final String USERPROFILE = "userProfile";
	protected static final String SHOPPING_CART = "shoppingCart";

	
	public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;
		// Gestion la cookie para ponerla en la session		
		HttpSession session = request.getSession(true);
		
		String uname = getCookieValue(request, USERNAME_COOKIE);
		if (uname != null )
			session.setAttribute(USERNAME_COOKIE,uname);
		try {
			forward = this.runAction(mapping, form, request, response, headerForm, footerForm);		
		} catch (ChangePasswordException chgpwdex) {
			forward = mapping.findForward("ChangePassword");
		}
			
		
		return forward;
	}
	
	public String getCookieValue(HttpServletRequest request, String name) {
		String value = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {		
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(name)) {
				value = cookies[i].getValue();
				break;
			}
		}
		}
		return value;
	}
	
	public void setCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(COOKIE_TIME_TO_LIVE);
		
		response.addCookie(cookie);
	}
	
	public abstract ActionForward runAction(		
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception;
		
		
}
