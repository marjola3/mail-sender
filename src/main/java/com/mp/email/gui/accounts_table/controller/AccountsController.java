package com.mp.email.gui.accounts_table.controller;

import com.mp.email.dao.UserDao;
import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import com.mp.email.log.AutowiredLogger;
import com.mp.email.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    public void init(){
        try {
            List<User> allUsers = userDao.findAllUsers();
            accountsTableModel.setUsers(allUsers);
        } catch (IOException e) {
            logger.error("Błąd podczas pobierania użytkowników", e);
        }
    }
}
