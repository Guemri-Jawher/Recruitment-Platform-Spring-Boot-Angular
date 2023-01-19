/*package com.example.demo.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MailService;
import com.example.demo.entity.Mail;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
    JavaMailSender mailSender;
	
	//@Override
	public void sendEmail(Mail mail, String email) {
		// TODO Auto-generated method stub
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
		 
	        try {
	 
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	 
	            mimeMessageHelper.setSubject(mail.getMailSubject());
	            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), email));
	            mimeMessageHelper.setTo(mail.getMailTo());
	            mimeMessageHelper.setText(mail.getMailContent());
	 
	            mailSender.send(mimeMessageHelper.getMimeMessage());
	 
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }

	}

}
*/