package com.tenneshop;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.Properties;

import javax.annotation.Resource;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import com.community.SiteApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SiteApplication.class})
@AutoConfigureMockMvc
public class EmailServiceTests {

	@Resource(name="blMailSender")
	JavaMailSender mailSender;
	
    @Test
    public void testContexLoads() throws Exception {
    	assertNotNull(mailSender);
    }
    
	@Test
	public void testMailSender() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("meiliang@Mac-mini.local");
		message.setTo("dongmeilianghy@sina.com");
		message.setSubject("Test Jave Mail Sender");
		message.setText("This mail is send via java mail sender.");

		try {
			mailSender.send(message);
			
			assertTrue(true);
		} catch (MailException e) {
			e.printStackTrace();
			
			fail(e.getCause().toString());
		}
	}
	
//	@Test
//	public void testSendMail() {
//
//		try {
//			EmailServiceTests.sendMail("meilaing@Mac-mini.local", "dongmeilianghy@sina.com", "Test Send Mail Via Java",
//					"Hello, Meiliang!");
//
//			assertTrue(true);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//
//			fail(e.getCause().toString());
//		}
//	}
//
//	public static void sendMail(String from, String to, String subject, String body) throws MessagingException {
//		final Properties p = new Properties();
//		p.put("mail.smtp.host", "localhost");
//		final Message msg = new MimeMessage(Session.getDefaultInstance(p));
//		msg.setFrom(new InternetAddress(from));
//		msg.addRecipient(RecipientType.TO, new InternetAddress(to));
//		msg.setSubject(subject);
//		msg.setText(body);
//		Transport.send(msg);
//	}

}
