package com.mp.email.gui.add_user.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Mariola
 */
@Component
public class AddUserDialog extends JDialog {

    @Autowired
    private AddUserFormPanel addUserPanelFormPanel;

    @Autowired
    private AddUserBtnPanel addUserBtnPanel;

    @Value("${gui.addUser.AddUserFrame.title}")
    private String frameTitle;

    public void init() {
        setUpFrame();
        initializeComponent();
    }

    private void setUpFrame() {
        setSize(200, 170);
        setLocationRelativeTo(null);
        setTitle(frameTitle);
        setResizable(false);
        setModal(true);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
    }

    private void initializeComponent() {
        add(addUserPanelFormPanel, BorderLayout.CENTER);
        add(addUserBtnPanel, BorderLayout.SOUTH);
    }
}
