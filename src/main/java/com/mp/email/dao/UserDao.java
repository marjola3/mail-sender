package com.mp.email.dao;


import com.mp.email.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.email.xls.XlsUserProvider;

import java.io.IOException;
import java.util.List;

public class UserDao {
    @Autowired
    private XlsUserProvider xlsUserProvider;

    public List<User> findAllUsers() throws IOException {
        return xlsUserProvider.getAllUsers();
    }
}
