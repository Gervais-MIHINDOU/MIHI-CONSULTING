package com.mihi.MIHI.service;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

/**
 *
 * @author Gervais Olsen
 */
public class GervaisMail {
    
	   public static void sendPlainTextEmail(String host, String port,
	            final String userName, final String password, String toAddress,
	            String subject, String message) throws AddressException,
	            MessagingException {

	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	     //
	         properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	       // properties.put("mail.smtp.ssl.trust", "*");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	 
	// *** BEGIN CHANGE
	        properties.put("mail.smtp.user", userName);

	        // creates a new session, no Authenticator (will connect() later);
	        Session session = Session.getDefaultInstance(properties);
	// *** END CHANGE

	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);

	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        // set plain text message
	        msg.setText(message);

	// *** BEGIN CHANGE
	        // sends the e-mail

 	        Transport t = session.getTransport("smtp");
	        t.connect(userName, password);
	        t.sendMessage(msg, msg.getAllRecipients());
	        t.close();
	// *** END CHANGE

	    }
}