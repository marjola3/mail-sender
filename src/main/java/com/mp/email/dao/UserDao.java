package com.mp.email.dao;


import com.mp.email.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.email.xls.XlsUserProvider;

import java.io.IOException;
import java.util.List;

public class UserDao implements IUserDao {
    @Autowired
    private XlsUserProvider xlsUserProvider;

    public List<User> findAllUsers() throws IOException {
        return xlsUserProvider.getAllUsers();
    }

    public void saveAllUsers(List<User> users) {
        xlsUserProvider.saveAllUser(users);
    }
}
