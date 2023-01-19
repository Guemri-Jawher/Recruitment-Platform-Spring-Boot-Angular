/*package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MailService;
import com.example.demo.entity.Mail;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MailControler {
	
	@Autowired
	private MailService service;
	
	@GetMapping("/sendMail/{email}/{content}/{mailcandi}")
	 public String sendMail(@PathVariable String email,@PathVariable String content ,@PathVariable String mailcandi ) {
		Mail mail = new Mail();
        mail.setMailFrom(email);
        mail.setMailTo(mailcandi);
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent(content);
		service.sendEmail(mail,email);		 
        return "Mail sender succes !" ;
	 }

}
*/