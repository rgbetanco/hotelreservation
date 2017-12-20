/*
 * Created on Feb 27, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.service;

import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

import com.nicahost.common.helper.MailSender;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClassifiedMailService {
	
	static Logger logger = Logger.getLogger(ClassifiedMailService.class);
	
	private static final String REPLY_TO = "reply-to-email";
	private static final String MAIL_MESSAGE_RESOURCE = "com.nicahost.module.classified.resource.ClassifiedMessageResource";
	
	private MessageResources resources;
	private static ClassifiedMailService mailService = null;
	private String from;

	private ClassifiedMailService() {
		from = ClasificadosInitParamBean.getInstance().getValue(REPLY_TO);
		resources = MessageResources.getMessageResources(MAIL_MESSAGE_RESOURCE);
	}
	
	public static ClassifiedMailService getInstance() {
		if (mailService == null) {
			mailService = new ClassifiedMailService();		
		}		
		return mailService;
	}
	
	public void sendMessageToSeller(String toEmail, String fromEmail, String subject, String productDescription, String body, String hideEmail, String copyEmail) {
		MailSender mail = new MailSender();
		mail.setFrom(this.from);
		mail.setTo(toEmail);
		mail.setSubject(productDescription.concat(" - ").concat(subject));
		if (hideEmail.equalsIgnoreCase("on")) {
			mail.setMessage("<p>Le estamos enviando este mensaje dado que un usuario" +
				" ha mostrado interes en su producto publicado en <a href=\"http://www.elcalachero.com\"> www.elcalachero.com</a>. </p>" +				"<p> Favor responder a la mayor brevedad posible. </p>" +
				" ---------------------------------------------------------------- <br>");
		} else {		
			mail.setMessage("<p>Le estamos enviando este mensaje dado que <a href=\"mailto:" + fromEmail + "\">"+ fromEmail + "</a>" +
				" ha mostrado interes en su producto publicado en <a href=\"http://www.elcalachero.com\"> www.elcalachero.com</a>. </p>" +				" <p> Favor  responder a la mayor brevedad posible. </p>" +
				" ---------------------------------------------------------------- <br>");
		}							
		mail.append(body);
		mail.sendMessage(true);
		
		if (copyEmail.equalsIgnoreCase("on")) {
			sendMessageToUser(toEmail,fromEmail,subject,productDescription,body);
		}
		
	}
	
	public void sendMessageToUser(String toEmail, String fromEmail, String subject, String productDescription, String body) {
		MailSender mail = new MailSender();
		mail.setFrom(this.from);
		mail.setTo(fromEmail);
		mail.setSubject(productDescription.concat(" - ").concat(subject));
		mail.setMessage("<p> Usted ha enviado el siguiente correo a " + toEmail +
					" solicitándole información sobre el siguiente producto: </p> " +					productDescription + 
					"<br>--------------------------------------------------------------</br>");
		mail.append(body);
		mail.sendMessage(true);
	}
	
	public void sendMessageNewAccountSeller(String toEmail) {
		MailSender mail = new MailSender();
		mail.setFrom(this.from);
		mail.setTo(toEmail);
		mail.setSubject("Confirmacion de cuenta de vendedor");
		mail.setMessage("Gracias por crear una cuenta en elcalachero.com.  Para empezar a vender sus" +			" productos favor presion ingrese al siguiente link:\n\n" +			"http://www.elcalachero.com/NicahostWeb/clasificados/activateselleraccount.do?emilio="+toEmail);	
		mail.sendMessage(false);		
	}

	public void sendMessageNewPassword(String toEmail, String newpass) {
		MailSender mail = new MailSender();
		mail.setFrom(this.from);
		mail.setTo(toEmail);
		mail.setSubject("Su cambio de contraseña");
		mail.setMessage("Su contraseña ha sido cambiada. \n\n\n" +
			" Su nueva contraseña es: "+ newpass +"\n\n" +
			"Ingrese nuevamente a http://www.elcalachero.com/NicahostWeb/clasificados/showSignin.do");	
		mail.sendMessage(false);		
	}	
}
