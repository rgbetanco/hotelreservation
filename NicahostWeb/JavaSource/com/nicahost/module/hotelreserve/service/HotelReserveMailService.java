package com.nicahost.module.hotelreserve.service;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

import com.nicahost.common.helper.MailSender;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitMailBean;

/**
 * Clase que gestiona el servicio para enviar correos electronicos de notificaciones.
 * 
 * @author Henry Jiron
 * @version 1.0
*/
public class HotelReserveMailService  {

	static Logger logger = Logger.getLogger(HotelReserveMailService.class);
	
	private static final String MAIL_MESSAGE_RESOURCE = "com.nicahost.module.hotelreserve.resource.HotelReserveMailMessageResource";
	private static final String SUBJECT_CONFIRMATION_KEY = "mail.confirmation.subject";
	private static final String BODY_CONFIRMATION_KEY = "mail.confirmation.body";
	
	
	private MessageResources resources;
	private static HotelReserveMailService collectorMailService = null;
	private String from;

	/**
	 * Constructor default.  Es private para seguir el modelo singleton.
	 *
	 */
	private HotelReserveMailService() {	
		resources = MessageResources.getMessageResources(MAIL_MESSAGE_RESOURCE);
		from = HotelReserveInitMailBean.getInstance().getFrom();
	}
	
	/**
	 * Retorna la instancia de esta clase, siguiendo el modelo singleton.
	 * 
	 * @return La instancia del servicio
	 */	
	public static HotelReserveMailService getInstance() {
		if (collectorMailService == null) {
			collectorMailService = new HotelReserveMailService();
		}
		
		return collectorMailService;				
	}	
		
	public void sendConfirmationNoticeToUser(String emailAddress, String userName, String code, Locale locale) {
		StringBuffer subject = new StringBuffer();
		StringBuffer body = new StringBuffer();
		
		subject.append(resources.getMessage(locale,SUBJECT_CONFIRMATION_KEY));
		body.append(resources.getMessage(locale,BODY_CONFIRMATION_KEY,userName, code));
		
		MailSender mail = new MailSender();
		mail.setFrom(from);
		mail.setTo(emailAddress);
		mail.setSubject(subject.toString());
		mail.setMessage(body);
		mail.sendMessage(false);
	}

	public void sendNotificationEmail(String emailAddress, String ref, String collectorName) {
		String mailSubject = resources.getMessage("collector.mail.subject.notification");
		String mailBody = resources.getMessage("collector.mail.body.notification01");
		mailBody += ref;
		mailBody += resources.getMessage("collector.mail.body.notification02");
		mailBody += collectorName;
		mailBody += resources.getMessage("collector.mail.body.notification03");
		MailSender mail = new MailSender();
		
		mail.setFrom(from);
		mail.setTo(emailAddress);
		mail.setSubject(mailSubject);
		mail.setMessage(mailBody);
		mail.sendMessage(false);
		
	}
	
	public void sendNotificationEmailToUsers(List emails, String ref, String collectorName) {
		String mailSubject = resources.getMessage("collector.mail.subject.notification");
		String mailBody = resources.getMessage("collector.mail.body.notification01");
		mailBody += ref;
		mailBody += resources.getMessage("collector.mail.body.notification02");
		mailBody += collectorName;
		mailBody += resources.getMessage("collector.mail.body.notification03");

		for(Iterator i = emails.iterator();i.hasNext();) {
			String emailAddress = (String) i.next();
			MailSender mail = new MailSender();
			mail.setFrom(from);
			mail.setTo(emailAddress);
			mail.setSubject(mailSubject);
			mail.setMessage(mailBody);
			mail.sendMessage(false);
		}
		
	}
	
	public void sendReceiptByEmail(List emails,String pathToFile) {
		
		String mailSubject = resources.getMessage("collector.mail.subject.receipt01");
	
		for(Iterator i = emails.iterator();i.hasNext();) {
			String emailAddress = (String) i.next();
			//if (isValidEmail(emailAddress)) {
				MailSender mail = new MailSender();
				mail.setFrom(from);				
				mail.setTo(emailAddress);
				mail.setSubject(mailSubject);
//				mail.setMessage(mailBody);
				mail.setFileName(pathToFile);
				mail.sendMessage(true);					
		}	
	}
	
/*	public boolean isValidEmail (String strng) {
		boolean res = true;

		if (strng != "") {
			String illegalChars = "[^\\s\\(\\)\\<\\>\\,\\;\\:\\\\\"\\[\\]@]";    
		    String emailFilter="^"+illegalChars+"+@"+illegalChars+"+\\."+illegalChars+"{2,3}$";

	    	StringBuffer test = new StringBuffer();
	    	
		    if (!(strng.trim().matches(emailFilter))) { 
    		   res = false;
		    }    
		}    
    return res;
	}
*/ 	
	
}
