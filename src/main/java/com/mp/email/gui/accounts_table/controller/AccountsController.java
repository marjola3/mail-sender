package com.mp.email.gui.accounts_table.controller;

import com.mp.email.dao.IUserDao;
import com.mp.email.dao.UserDao;
import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import com.mp.email.gui.accounts_table.view.AccountsFrame;
import com.mp.email.gui.accounts_table.view.ButtonPanel;
import com.mp.email.gui.accounts_table.view.TablePanel;
import com.mp.email.log.AutowiredLogger;
import com.mp.email.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

/**
 * Author: Mariola
 */
@Controller
public class AccountsController {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private AccountsTableModel accountsTableModel;

    @Autowired
    private ButtonPanel buttonPanel;

    @Autowired
    private TablePanel tablePanel;

    @Autowired
    private AccountsFrame accountsFrame;

    @Value("${accountsControler.removePaneMessage}")
    private String removePaneMessage;

    @Value("${accountsControler.removePaneTitle}")
    private String remevePaneTitle;

    public void init(){
        findUsersAndFillTable();
        initializeBtns();
        accountsFrame.addWindowListener(new AccountsWindowListener());
    }

    private void initializeBtns() {
        JButton sendBtn = buttonPanel.getSendBtn();
        sendBtn.addActionListener(new SendBtnListener());

        JButton addBtn = buttonPanel.getAddBtn();
        addBtn.addActionListener(new AddBtnListener());

        JButton removeBtn = buttonPanel.getRemoveBtn();
        removeBtn.addActionListener(new RemoveBtnListener());
    }

    private void findUsersAndFillTable() {
        try {
            List<User> allUsers = userDao.findAllUsers();
            AccountsTableModel model = tablePanel.getAccountsTableModel();
            model.setUsers(allUsers);
        } catch (IOException e) {
            logger.error("Could not get users", e);
        }
    }

    class SendBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("send");
        }
    }

    class AddBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("add");
        }
    }

    class RemoveBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTable jTable = tablePanel.getTable();
            AccountsTableModel model = tablePanel.getAccountsTableModel();

            int[] selectedRows = jTable.getSelectedRows();

            if(selectedRows.length > 0) {
                model.remove(selectedRows);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        removePaneMessage,
                        remevePaneTitle,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class AccountsWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Czy chcesz?",
                    "Informacja",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                saveAllUsers();
                System.exit(0);
            } else if(result == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }

    private void saveAllUsers() {
        AccountsTableModel model = tablePanel.getAccountsTableModel();
        userDao.saveAllUsers(model.getUsers());
    }
}
