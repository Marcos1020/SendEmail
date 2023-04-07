package com.sendEmail.entity;

import com.sendEmail.status.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_EMAIL")
public class EmailEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EMAIL")
    private Long idEmail;

    @Column(name = "OWNER_REF")
    private String ownerRef;

    @Column(name = "EMAIL_FROM")
    private String emailFrom;

    @Column(name = "EMAIL_TO")
    private String emailTo;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATE_SEND")
    private Date sendDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;

}
