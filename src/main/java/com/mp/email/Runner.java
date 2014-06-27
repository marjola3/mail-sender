package com.mp.email;

import com.mp.email.gui.accounts_table.view.AccountsFrame;
import com.mp.email.util.ApplicationUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mp.email.service.MailService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        try {
            ApplicationUtil.changeLookAndFeelToSystemLookAndFeel();

            ApplicationContext context =
                    new ClassPathXmlApplicationContext("base_context.xml");

            AccountsFrame frame = context.getBean("accountsFrame", AccountsFrame.class);
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            frame.setVisible(true);
        } catch (BeansException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    /*private static void sendEmail(ApplicationContext context) {
        MailService mailService = context.getBean("mailService", MailService.class);

        String from = "polak.mariola@gmail.com";
        String to = "marjola3@poczta.onet.pl";
        String subcject = "subcject";
        String text = "message";

        boolean czyWysłany = mailService.sendEMail(from, to, subcject, text);

        System.out.println("Czy wysłano e-mail? " + czyWysłany);
    }*/
}