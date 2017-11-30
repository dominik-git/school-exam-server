package sk.bavaria.bavaria.service;

/**
 * Created by dominik.kolesar on 11/22/2017.
 */

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.bavaria.bavaria.model.User;


@RestController
@RequestMapping("/sendEmail")
@Api(value = "send", description = "send email")
public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    private JavaMailSender javaMailSender;

    @Autowired
    public void NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void buildEmail(User user) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(user.getEmailAddress());
        mail.setTo("justifycontent1@gmail.com");
        mail.setReplyTo(user.getEmailAddress());
        mail.setSubject(user.getSubject());
        mail.setText("from: "+ user.getEmailAddress()+"  "+user.getMessage());
        javaMailSender.send(mail);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void sendEmail(@RequestBody User user) {
        try {
            log.debug("Sending email from {}", user.getEmailAddress());
            this.buildEmail(user);
        } catch (MailException e) {
            log.error("Error while sending emiail", e);
        }
    }


}
