package com.sendEmail.config.convert;

import com.sendEmail.controller.request.EmailRequest;
import com.sendEmail.entity.EmailEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j
public class Convertions {

    public EmailEntity converterEmailRequestParaEmailEntity(EmailRequest request, Date sendingDate) {

        EmailEntity entity = new EmailEntity();
        entity.setEmailFrom("marcossanches710@gmail.com");
        entity.setOwnerRef("One_Digital_LTDA");
        entity.setEmailTo(request.getEmailTo());
        entity.setStatusEmail(request.getStatusEmail());
        entity.setSubject(request.getSubject());
        entity.setText("Cadastro efetuado com sucesso");
        entity.setSendDate(sendingDate);
        return entity;
    }
}