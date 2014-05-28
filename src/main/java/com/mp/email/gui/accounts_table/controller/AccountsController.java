package com.mp.email.gui.accounts_table.controller;

import com.mp.email.dao.UserDao;
import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import com.mp.email.gui.accounts_table.view.ButtonPanel;
import com.mp.email.log.AutowiredLogger;
import com.mp.email.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private UserDao userDao;

    @Autowired
    private AccountsTableModel accountsTableModel;

    @Autowired
    private ButtonPanel buttonPanel;

    public void init(){
        findUsersAndFillTable();

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
            accountsTableModel.setUsers(allUsers);
        } catch (IOException e) {
            logger.error("Błąd podczas pobierania użytkowników", e);
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
            logger.info("remove");
        }
    }


}
