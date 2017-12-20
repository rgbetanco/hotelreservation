package com.nicahost.common.helper;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;


/**
 * Hilo que envia correo
 * 
 * @author Henry Jiron
 * @version 1.0
 */
public class SendMailThread extends Thread {
	
	static Logger logger = Logger.getLogger(SendMailThread.class);
	
    private String server = "";
    //private int port = 25;
    private String fileName = "";
    private String from = "";
    private String to = "";
    private String subject = "";
    private StringBuffer message = new StringBuffer();
    private boolean hasAttach = false;
    String resultMessage = "";
    private boolean html = false;
    private boolean result = false;


	/**
	 * Constructor for SendMailThread.
	 */
	public SendMailThread() {
		super();
	}


	/**
	 * Constructor for SendMailThread.
	 * @param name
	 */
	public SendMailThread(String name) {
		super(name);
	}

    public void append(String value) {
        if (value != null)
            this.message.append(value);
    }

    public void run() {
        setPriority(this.MIN_PRIORITY);
        try {
            // create a message
            java.util.Properties properties = System.getProperties();
            properties.put("mail.smtp.host", server);
            javax.mail.Session session = javax.mail.Session.getInstance(properties, null);
            Message msg = new MimeMessage(session);
            // set the from
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            if (!html) {
                // send a plain text message
                msg.setContent(message.toString(), "text/html");
            } else {
                // send a multipart message
                // create and fill the first message part
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(message.toString(), "text/html");
                // create and fill the second message part
                MimeBodyPart mbp2 = new MimeBodyPart();
                mbp2.setContent(message.toString(), "text/plain");

                // create the Multipart and its parts to it
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);

                if (hasAttach) {
                    BodyPart mbp3 = new MimeBodyPart();
                    DataSource source = new FileDataSource(fileName);
                    // Set the data handler to the attachment
                    mbp3.setDataHandler(new DataHandler(source));
                    // Set the filename
                    mbp3.setFileName(fileName);
                    mp.addBodyPart(mbp3);
                }
                // add the Multipart to the message
                msg.setContent(mp);
            }
            Transport.send(msg);
            this.result = true;
            logger.info("Message sent to:" + to);            
        } catch (MessagingException mex) {
            String error = mex.toString();
            resultMessage = error;
            System.out.println(error);
            mex.printStackTrace();
            this.result = false;
        }
    }

    public void setFileName(String value) {
        fileName = value;
        hasAttach = true;
    }

    public void setFrom(String value) {
        from = value;
    }

    /**
     * Insert the method's description here.
     * Creation date: (1/14/2003 6:08:26 PM)
     *
     * @param hasAttach boolean
     */
    public void setHasAttach(boolean value) {
        this.hasAttach = value;
    }

    /**
     * Insert the method's description here.
     * Creation date: (1/14/2003 6:11:57 PM)
     *
     * @param html boolean
     */
    public void setHtml(boolean value) {
        this.html = value;
    }

    /**
     * Setea el mensaje a enviar
     * Creation date: (06/01/2003 9:32:18 AM)
     *
     * @param value java.lang.String el valor del mensaje del emisor
     */
    public void setMessage(String value) {
        if (value != null)
            this.message.append("\r\n").append(value);
    }

    public void setMessage(StringBuffer value) {
        message = value;
    }

    public void setServer(String value) {
        server = value;
    }

    public void setSubject(String value) {
        subject = value;
    }

    public void setTo(String value) {
        to = value;
    }
}



