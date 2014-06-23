package com.mp.email.gui.add_user.view;

import com.mp.email.gui.add_user.controler.AddUserControler;
import com.mp.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Mariola
 */
@Component
public class AddUserFormPanel extends JPanel{

    public void init() {
        preparePanel();
    }

    private void preparePanel() {
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Imię:"));
        add(new JTextField());
        add(new JLabel("Nazwisko:"));
        add(new JTextField());
        add(new JLabel("E-mail:"));
        add(new JTextField());
    }
}
