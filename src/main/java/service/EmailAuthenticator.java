package service;

import org.springframework.beans.factory.annotation.Value;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by Mariola on 2014-04-17.
 */
public class EmailAuthenticator extends Authenticator {
    @Value("sender.username")
    private String username;
    
    @Value("sender.password")
    private String password;

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
