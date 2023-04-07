package com.sendEmail.controller;

import com.sendEmail.controller.request.EmailRequest;
import com.sendEmail.exception.PreconditionFailedException;
import com.sendEmail.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailservice;

    @PostMapping
    @Operation(description = "EndPoint para envio de email")
    public ResponseEntity<Void> SendingEmail(
            @RequestBody EmailRequest emailRequest) throws PreconditionFailedException {
        emailservice.sendEmail(emailRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
