package com.mp.email.gui.add_user.controler;

import com.mp.email.gui.add_user.view.AddUserBtnPanel;
import com.mp.email.gui.add_user.view.AddUserDialog;
import com.mp.email.log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Mariola
 */
@Controller
public class AddUserControler {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private AddUserBtnPanel addUserBtnPanel;

    @Autowired
    private AddUserDialog addUserDialog;

    public void init(){
        initializeBtns();
    }

    private void initializeBtns() {
        JButton saveBtn = addUserBtnPanel.getSaveBtn();
        saveBtn.addActionListener(new SaveBtnActionListener());

        JButton cancelBtn = addUserBtnPanel.getCancelBtn();
        cancelBtn.addActionListener(new CancelBtnActionListener());
    }

    class SaveBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("Zapisz");
        }
    }

    class CancelBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addUserDialog.dispose();
        }
    }
}
