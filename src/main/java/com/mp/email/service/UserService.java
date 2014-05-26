package com.mp.email.service;

import com.mp.email.dao.UserDao;
import com.mp.email.log.AutowiredLogger;
import com.mp.email.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class UserService {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() throws IOException {
        logger.info("Pobranie wszystkich użytkowników");
        return userDao.findAllUsers();
    }
}
