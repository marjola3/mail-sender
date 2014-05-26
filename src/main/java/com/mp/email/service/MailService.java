package com.mp.email.service;


import com.mp.email.log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {
    @AutowiredLogger
    private Logger logger;

    @Value("${mail.smtp.auth}")
    private String auth;

    @Value("${mail.smtp.starttls.enable}")
    private String starttlsEnable;

    @Value("${mail.smtp.host}")
    private String host;

    @Value("${mail.smtp.port}")
    private String port;

    @Autowired
    private EmailAuthenticator emailAuthenticator;

    public boolean sendEMail(String from, String to, String subject, String text) {
        try {
            Session session =
                   Session.getInstance(getProperties(), emailAuthenticator);

            Message message = createMessage(from, to, subject, text, session);
            Transport.send(message);

            logger.info("Wysłano email do: " + to);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Message createMessage(String from, String to, String subject, String text, Session session)
            throws MessagingException {
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

        message.setSubject(subject);

        message.setText(text);
        return message;
    }

    private Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", starttlsEnable);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        return props;
    }
}
