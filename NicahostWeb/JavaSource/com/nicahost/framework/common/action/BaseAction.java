package com.nicahost.framework.common.action;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import com.nicahost.framework.common.NavigationItem;
import com.nicahost.common.exception.SbeException;
import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.framework.common.form.ErrorForm;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;


/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public abstract class BaseAction extends Action {

	protected static Logger log = Logger.getLogger(BaseAction.class);
	/**
	 * The default execute method that all actions must have.  Child actions
	 * should not overload this method. 
	 *
	 * @param mapping The set of mappings
	 * @param form The form this action refers to
	 * @param request The http servlet request
	 * @param response The http servlet response
	 * @return The next action to be executed or the next page to display
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		HeaderForm headerForm = null;
		FooterForm footerForm = null;
		Vector navigationItems = new Vector();
		
		log.info("Executing " + this.getClass().getName());			
		
    	HttpSession httpSession = null;    	        
	    httpSession =  request.getSession();
		//String locale = (String)httpSession.getAttribute("locale");    // Lenguaje del usuario.		
		MessageResources resources = (MessageResources)request.getAttribute(Globals.MESSAGES_KEY);		
		
		headerForm = this.createHeader(request);		
		footerForm = this.createFooter(request);
		

		//que de esta forma no se puede leer de varios archivos de resources, por tanto
		//en el mismo archivo de resources se especifican llaves completadas con el locale.
		navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav1"), null));			
		navigationItems.addElement(new NavigationItem(resources.getMessage("label.nav2"), null));
		headerForm.setNavigationItems(navigationItems);
	
		try {	
			
			this.setLocale(request,this.getLocale(request));			
			forward = this.executeAction(mapping,form,request,response,headerForm,footerForm);
		

		} catch ( BaseException bex) {
		//Es una excepcion que debe mostrarse al usuario y devolverle la misma pantalla con los datos capturados
			log.warn("Warning: " + this.getClass().getName()+ ".excuteAction: " + bex.getMessageKey());			
			forward = this.processBaseExceptions(request, mapping, bex);

		} catch (SbeException sbex) {
			log.error("Error at " + this.getClass().getName() + ".executeAction: "+sbex.getMessage());
			createErrorForm(request, "", "",sbex.getExceptionCode(),sbex.getMessage(), navigationItems);        
			forward = mapping.findForward("GeneralError");			

		} catch (Exception ex) {
		//Si es una excepcion que no conozco envio una excepcion de Aplicacion No Disponible
	    	log.error("Error at " + this.getClass().getName() + ".executeAction: "+ex.getMessage());
        	createErrorForm(request, "", ex.getClass().getName(),"",ex.getLocalizedMessage(), navigationItems);        
	        forward = mapping.findForward("GeneralError");				
		}

		log.debug("Done executing " + this.getClass().getName());	
		
		request.setAttribute("headerForm",headerForm);
		request.setAttribute("footerForm",footerForm);

		return forward;
	}

	/**
	 * Prepares an error page with the given information
	 *
	 * @param request The <code>HttpServletRequest</code> object
	 * @param title The title to show on the Error page
	 * @param reference The reference id of the error
	 * @param code The code number of the error
	 * @param description A brief description of the error
	 * @param navigationItems The links path to display in the header
	 */
	public void createErrorForm(HttpServletRequest request, String title, String reference, String code, String description, Vector navigationItems) {
		ErrorForm errorForm = null;
		errorForm = new ErrorForm();
		errorForm.setTitle(title);
		errorForm.setReference(reference);
		errorForm.setCode(code);
		errorForm.setText(description);
		request.setAttribute("navigationItems", navigationItems);
		request.setAttribute("errorForm", errorForm);

	}
	
	/**
	 * Creates a form containing all the footer information to display to the user.
	 *
	 * @param request The <code>HttpServletRequest</code> object
	 * @return A <code>FooterForm</code> containing all the header information
	 */
	private HeaderForm createHeader(HttpServletRequest request) {
		HeaderForm headerForm = null;
		headerForm = new HeaderForm();
		return headerForm;
	}
	
	/**
	 * Creates a form containing all the footer information to display to the user.
	 *
	 * @param request The <code>HttpServletRequest</code> object
	 * @return A <code>FooterForm</code> containing all the header information
	 */
	private FooterForm createFooter(HttpServletRequest request) {
		FooterForm footerForm = null;
		footerForm = new FooterForm();
		return footerForm;
	}	
	
	/**
	 * Procesa las excepciones generadas en la presente aplicacion
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	protected ActionForward processBaseExceptions(HttpServletRequest request,
											 ActionMapping mapping,
											 BaseException bex) {

//		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward = null;
		
		//Get the locale for the user
		Locale locale = getLocale(request);
		
				
		this.processBaseException(messages, bex, locale);
		
		
		//Either return to the input resource or a configured failure forward
		String inputStr = mapping.getInput();
		ActionForward failureForward = mapping.findForward("Failure");
		
		if (inputStr != null) {
			forward = new ActionForward(inputStr);
		} else if (failureForward != null) {
			forward = failureForward;
		}
		
		//See if this exception contains a list of subexceptions
		List exceptions = bex.getExceptions();
		if (exceptions != null && !exceptions.isEmpty()) {
			Iterator ii = exceptions.iterator();
			while (ii.hasNext()) {
				BaseException subException = (BaseException) ii.next();
				this.processBaseException(messages,subException,locale);
			}
			
		}	
	
		//Tell Struts framework to save the errors into the request
		saveErrors(request,messages);
		
		
		return forward;		
	}
	

	/**
	 * Procesa excepcion por excepcion	 
	 * @param
	 * @param
	 * @param
	 * @return
	 * */	
	protected	void processBaseException(ActionMessages messages,
											BaseException bex, 
											Locale locale) {
		
//		ActionError newActionError = null;
		ActionMessage newActionMessage = null;
		
		String errorCode = bex.getMessageKey();
		Object[] args = bex.getMessageArgs();												
		
		//Now construct an instance of the ActionError class
		if (args != null && args.length > 0) {
			newActionMessage = new ActionMessage(errorCode,args );
		} else {
			newActionMessage = new ActionMessage( errorCode);
		}
		
		messages.add("GLOBAL_ERROR",newActionMessage);	
	}

	/** 
	* Obtiene el Locale asignado para el actual usuario. 
	* @return Locale idioma del usuario. 
	*/
	protected Locale getLocale(HttpServletRequest request) {
		Locale local = (Locale) javax.servlet.jsp.jstl.core.Config.get(request.getSession(), javax.servlet.jsp.jstl.core.Config.FMT_LOCALE);
		if (local == null) { 
			local = new Locale("es", "NI"); // Lenguaje por defecto. 
		}
		
		return local;
	}
	
	/**
	 * Carga los locales para jstl y las librerias de apache.
	 * @param request de la invocación.
	 * @param lang Lenguaje a utilizar para la construcción del local.
	 * @param country País a utilizar para la construcción del local.
	 */
	public void setLocale(HttpServletRequest request, String lang, String country) {
		Locale locale = new Locale(lang, country);
		this.setLocale(request, locale);
	}
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#setLocale(javax.servlet.http.HttpServletRequest, java.util.Locale)
	 */
	public void setLocale(HttpServletRequest request, Locale locale) {
		//Asigna el local para las librerias de apache
		super.setLocale(request, locale);
		//Asigan el local para JSTL
		Config.set(request.getSession(), Config.FMT_LOCALE, locale);
		request.getSession().setAttribute("locale",locale);
	}	


	/**
	 * The actual do work method that must be overrriden by the subclasses.
	 *
	 * @param mapping The set of mappings
	 * @param form The form this action refers to
	 * @param request The http servlet request
	 * @param response The http servlet response
	 * @return The next action to be executed or the next page to display
	 */
	public abstract ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, HeaderForm headerForm, FooterForm footerForm) throws Exception;



}
