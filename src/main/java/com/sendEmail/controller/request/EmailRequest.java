package com.sendEmail.controller.request;

import com.sendEmail.status.StatusEmail;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class EmailRequest {

    @NotBlank
    private String ownerRef;

    @NotBlank
    @Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    @NotBlank
    private StatusEmail statusEmail;
}
