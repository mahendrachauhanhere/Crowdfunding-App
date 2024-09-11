package Utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
	public static void main(String[] args) {
		final String username = "mahendrac.itpath@gmail.com"; // Replace with your email
		final String password = "Admin@_1996"; // Replace with your email password

		// SMTP server configuration
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your SMTP server
		props.put("mail.smtp.port", "587"); // Typically 587 for TLS

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mahendrac.itpath@gmail.com")); // Replace with your email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mahendrac.itpath@gmail.com")); // Replace
																												// with
																												// recipient's
																												// email
			message.setSubject("Extent Report - Test Results");

			// Create the email content
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Please find the attached Extent Report.");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Attach the report
			messageBodyPart = new MimeBodyPart();
			String filename = "extentReport.html";
			((MimeBodyPart) messageBodyPart).attachFile(filename);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// Send the email
			Transport.send(message);

			System.out.println("Email sent successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
