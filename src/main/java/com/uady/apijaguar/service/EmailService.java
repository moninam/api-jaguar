package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.uady.apijaguar.dto.EmailDto;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class EmailService {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
	private JavaMailSender sender;

    @Async
	public void sendEmail(EmailDto emailBody) {
		logger.info("EmailBody: {}", emailBody.toString());
		sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
	}
	

	private boolean sendEmailTool(String textMessage, String email,String subject) {
		boolean send = false;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);		
		try {
			helper.setTo(email);
			helper.setText(textMessage, true);
			helper.setSubject(subject);
			sender.send(message);
			send = true;
			logger.info(Constantes.EMAIL_SEND);
		} catch (MessagingException e) {
			logger.error("Hubo un error al enviar el mail: {}", e);
		}
		return send;
	}
}
