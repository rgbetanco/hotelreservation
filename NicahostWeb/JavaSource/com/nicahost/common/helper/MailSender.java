package com.nicahost.common.helper;

import com.nicahost.common.config.bean.GlobalParametersBean;

/**
 * Clase que envia email
 * 
 * @author Henry Jiron
 * @version 1.0
 */
public class MailSender {

    private SendMailThread mail;

    private String server;
    



    /**
     * Constructor de la clase
     */
    public MailSender() {
        this.mail = new SendMailThread();
        server = GlobalParametersBean.getInstance().getValue(GlobalParametersBean.SMTP_IP);
        
        this.setServer(server);
        
    }


    /**
     * Realiza un apéndice al mensaje actual
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del mensaje a agregar
     */
    public void append(String value) {
        this.mail.append(value);
    }


/*    public static void main(String[] args) {
        MailSender ms = new MailSender();
        try {
            ms.setFrom("czamora@hdegroup.com");
            ms.setTo("rsoto@hdegroup.com,jaguilar@hdegroup.com,valfaro@hdegroup.com");
            ms.setSubject("Prueba");
            ms.setMessage("<html><body><h1>Por fin llego!!!!</h1></body></html>");
            ms.setServer("smtp.hdegroup.com");
            //ms.setFileName("c:\\repuesta.html");
            //ms.sendMessage(true);
            ms.sendMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    /**
     * Realiza el envío del correo, ya sea en formato html o texto plano.
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param html boolean, indica si el correo a enviar es formato html o texto plano
     * @return boolean
     */
    public void sendMessage(boolean html) {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }
        this.mail.setHtml(html);
        this.mail.start();

    }

    /**
     * Setea el archivo asociado a enviar
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del archivo
     */
    public void setFileName(String value) {
        this.mail.setFileName(value);
        this.mail.setHasAttach(true);
    }

    /**
     * Setea el email del emisor
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del email del emisor
     */
    public void setFrom(String value) {
        this.mail.setFrom(value);
    }

    /**
     * Setea el mensaje a enviar
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del mensaje del emisor
     */
    public void setMessage(String value) {
        this.mail.append("\r\n");
        this.mail.append(value);
    }

    /**
     * Setea el mensaje a enviar pero con un StringBuffer
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value StringBuffer el valor del email del emisor
     */
    public void setMessage(StringBuffer value) {
        this.mail.append("\r\n");
        this.mail.append(value.toString());
    }
    /**
     * Setea el puerto para la conexión del servidor
     * Creation date: (06/01/2003 9:32:18 AM)
     * @param value String el valor del puerto
     */
/*public void setPort(String value) {
	try {
		this.port = new Integer(value).intValue();
	}
	catch(Exception e) {
	}
}*/
    /**
     * Setea el servidor de correos
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del servidor de correos
     */
    public void setServer(String value) {
        this.mail.setServer(value);
    }

    /**
     * Setea el subject del correo
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del subject del correo
     */
    public void setSubject(String value) {
        this.mail.setSubject(value);
    }

    /**
     * Setea el email del destinatario
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del email del destinatario
     */
    public void setTo(String value) {
        this.mail.setTo(value);
    }

}
