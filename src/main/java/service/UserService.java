package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
