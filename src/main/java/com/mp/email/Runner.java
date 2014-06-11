package com.mp.email;

import com.mp.email.gui.accounts_table.view.AccountsFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mp.email.service.MailService;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("base_context.xml");

//        sendEmail(context);

        AccountsFrame frame = context.getBean("accountsFrame", AccountsFrame.class);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void sendEmail(ApplicationContext context) {
        MailService mailService = context.getBean("mailService", MailService.class);

        String from = "polak.mariola@gmail.com";
        String to = "marjola3@poczta.onet.pl";
        String subcject = "subcject";
        String text = "message";

        boolean czyWysłany = mailService.sendEMail(from, to, subcject, text);

        System.out.println("Czy wysłano e-mail? " + czyWysłany);
    }
}