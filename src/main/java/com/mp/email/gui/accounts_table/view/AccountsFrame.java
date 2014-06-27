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
    private TablePanel accountsPanel;

    @Autowired
    private ButtonPanel buttonPanel;

    public void init() {
        setUpFrame();
        initializeComponent();
    }

    private void setUpFrame() {


        setSize(600, 510);
        setLocationRelativeTo(null);
        setTitle(frameTitle);
        setResizable(false);
    }

    private void initializeComponent() {
        add(accountsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
