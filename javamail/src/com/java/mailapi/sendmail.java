package com.java.mailapi;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendmail {

	public static void mail(String receipent) throws Exception {
		System.out.println("Preparing to send mail !!");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");

		String myEmail = "vasudevansoni07@gmail.com";
		String myPassword = "9898744559";

		Session sess = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myEmail, myPassword);
			}
		});

		Message message = prepareMessage(sess, myEmail, receipent);
		Transport.send(message);
		System.out.println("Message sent Successfully !!!");

	}

	private static Message prepareMessage(Session sess, String myEmail, String receipent) {
		try {
			Message message = new MimeMessage(sess);
			message.setFrom(new InternetAddress(myEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipent));
			message.setText("Hello !!");
			message.setSubject("This is my first email from java !");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
