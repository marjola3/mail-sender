package com.mp.email.gui.add_user.controler;

import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import com.mp.email.gui.add_user.view.AddUserBtnPanel;
import com.mp.email.gui.add_user.view.AddUserDialog;
import com.mp.email.gui.add_user.view.AddUserFormPanel;
import com.mp.email.log.AutowiredLogger;
import com.mp.email.model.User;
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
    private AddUserDialog addUserDialog;

    @Autowired
    private AddUserFormPanel addUserFormPanel;

    @Autowired
    private AddUserBtnPanel addUserBtnPanel;

    @Autowired
    private AccountsTableModel accountsTableModel;

    public void init() {
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
            String name = addUserFormPanel.getNameTF().getText();
            String surname = addUserFormPanel.getSurnameTF().getText();
            String email = addUserFormPanel.getEmailTF().getText();

            if (isFormFilled(name, surname, email)) {
                User user = new User(name, surname, email);
                accountsTableModel.addUser(user);
                addUserDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Nie podano wszystkich danych.\n" +
                        "Minimalna długość znaków dla każdego pola wynosi 3",
                        "Info",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    class CancelBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addUserDialog.dispose();
        }
    }

    public boolean isFormFilled(String... args) {
        if (args == null) return false;

        for (String field : args) {
            if (field == null || field.length() < 3) {
                return false;
            }
        }
        return true;
    }
}
