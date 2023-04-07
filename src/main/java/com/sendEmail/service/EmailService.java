package com.sendEmail.service;

import com.sendEmail.config.convert.Convertions;
import com.sendEmail.controller.request.EmailRequest;
import com.sendEmail.entity.EmailEntity;
import com.sendEmail.exception.PreconditionFailedException;
import com.sendEmail.repository.EmailRepository;
import com.sendEmail.status.StatusEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Slf4j
@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final Convertions convertions;
    private final JavaMailSender emailSender;
    @Autowired
    public EmailService(EmailRepository emailRepository, Convertions convertions, JavaMailSender emailSender ){
        this.emailRepository = emailRepository;
        this.convertions = convertions;
        this.emailSender = emailSender;
    }

    public void sendEmail(EmailRequest emailRequest)throws PreconditionFailedException {

        Date sendDate = new Date();

        try{
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("marcossanches710@gmail.com");
            helper.setTo(emailRequest.getEmailTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText("cadastro efetuado com sucesso");
            helper.setSentDate(sendDate);
            emailSender.send(message);
            emailRequest.setStatusEmail(StatusEmail.SEND.SEND);

            EmailEntity emailEntity = convertions.converterEmailRequestParaEmailEntity(emailRequest, sendDate);

            this.emailRepository.save(emailEntity);
        }catch (MessagingException error){
            log.error("Erro ao enviar o email", error);
            emailRequest.setStatusEmail(StatusEmail.ERROR);
            throw new RuntimeException("Falha no envio do email");
        }
    }
}