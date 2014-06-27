package com.mp.email.gui.add_user.view;

import com.mp.email.gui.add_user.controler.AddUserControler;
import com.mp.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Mariola
 */
@Component
public class AddUserFormPanel extends JPanel{

    @Value("${gui.addUser.AddUserFormPanel.nameText}")
    private String nameText;

    @Value("${gui.addUser.AddUserFormPanel.surnameText}")
    private String surnameText;

    @Value("${gui.addUser.AddUserFormPanel.emailText}")
    private String emailText;

    private JTextField nameTF;

    private JTextField surnameTF;

    private JTextField emailTF;

    public void init() {
        preparePanel();
    }

    private void preparePanel() {
        setLayout(new GridLayout(3, 2, 10, 10));

        nameTF = new JTextField();
        surnameTF = new JTextField();
        emailTF = new JTextField();

        add(new JLabel(nameText));
        add(nameTF);
        add(new JLabel(surnameText));
        add(surnameTF);
        add(new JLabel(emailText));
        add(emailTF);
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getSurnameTF() {
        return surnameTF;
    }

    public JTextField getEmailTF() {
        return emailTF;
    }
}
