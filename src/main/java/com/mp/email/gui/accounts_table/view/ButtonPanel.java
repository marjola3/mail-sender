package com.mp.email.gui.accounts_table.view;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Author: Mariola
 */
@Component
public class ButtonPanel extends JPanel {

    private JButton sendBtn;

    private JButton addBtn;

    private JButton removeBtn;

    @PostConstruct
    public void initializeComponents() {
        sendBtn = new JButton("Wyślij");
        addBtn = new JButton("Dodaj");
        removeBtn = new JButton("Usuń");

        add(sendBtn);
        add(addBtn);
        add(removeBtn);
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }
}
