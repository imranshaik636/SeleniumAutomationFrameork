package demo;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {
	public static void main(String[] args) {
		final String senderEmail = "ayushmanpurhana@gmail.com";
		final String appPassword = "uoesgjewcgykqkzr";
		final String recepientEmail = "ayushmanpurhana@gmail.com";
		
		//SMTP SERVER PROPERTIES
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		
		//CREATE SESSION WITH AUTHENTICATOR
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		}
		);
		session.setDebug(true);
		
		try {
			//CREATE EMAIL MESSAGE
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
			message.setSubject("Test Email from QA Automation");
			//message.setText("Hello \n This is test email from Java \n Thanks, \n QA Team");
			
			//Body part
			MimeBodyPart textpart = new MimeBodyPart();
			textpart.setText("Hello \n  This is test email from Java \n  Thanks, \n  QA Team");
			
			//Attachment
			MimeBodyPart attachmentpart = new MimeBodyPart();
			String filePath = System.getProperty(("user.dir")) + "/reports/extentreport.html";
			System.out.println("Attachment path is - "+ filePath);
			attachmentpart.attachFile(new File(filePath));
			
			//combine body attachment part
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textpart);
			multipart.addBodyPart(attachmentpart);
			message.setContent(multipart);
			
			//SEND MAIL
			Transport.send(message);
			System.out.println("Email sent successfully");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
