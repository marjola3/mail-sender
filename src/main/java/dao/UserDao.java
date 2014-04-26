package dao;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import xls.XlsUserProvider;

import java.util.List;

public class UserDao {
    @Autowired
    private XlsUserProvider xlsUserProvider;

    public List<User> findAllUsers() {
        return xlsUserProvider.getAllUsers();
    }
}
