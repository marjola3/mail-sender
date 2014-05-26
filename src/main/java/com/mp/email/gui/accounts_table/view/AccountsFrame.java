package com.mp.email.gui.accounts_table.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AccountsFrame extends JFrame {

    @Value("${gui.accountsTable.AccountsFrame.title}")
    private String frameTitle;

    @Autowired
    private AccountsPanel accountsPanel;

    public void init() {
        setSize(500, 500);
        setLocationRelativeTo(null);

        setTitle(frameTitle);
        initializeComponent();
    }

    private void initializeComponent() {
        add(accountsPanel, BorderLayout.CENTER);
    }
}
