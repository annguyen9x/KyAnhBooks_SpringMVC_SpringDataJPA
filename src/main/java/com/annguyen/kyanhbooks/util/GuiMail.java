package com.annguyen.kyanhbooks.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class GuiMail {
	
	public static boolean guiMail(String emailNhan, String tieuDe, String noiDung, String emailShop, String matKhauEmailShop) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailShop, matKhauEmailShop);
			}
		});
		
		Message message = new MimeMessage(session);
		
		try {
			message.setHeader("Content-Type", "text/plain; charset=utf-8");
			message.setFrom(new InternetAddress(Constant.CauHinh.TEN_THAMSO_EMAIL_SHOP));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailNhan));
			message.setSubject(tieuDe);
			message.setText(noiDung);
			Transport.send(message);
		} catch (MessagingException e) {
			return false;
		} 
		return true;
	}
}
