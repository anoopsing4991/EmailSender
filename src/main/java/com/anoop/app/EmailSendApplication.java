package com.anoop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.anoop.bean.Mail;
import com.anoop.services.MailService;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.technicalkeeda"
	})
public class EmailSendApplication {

	public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setMailFrom("Sender email");
        mail.setMailTo("Receiver email");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!");

        ApplicationContext ctx = SpringApplication.run(EmailSendApplication.class, args);
        MailService mailService = ctx.getBean("mailService",MailService.class);
      mailService.sendEmail(mail);
	}

}
