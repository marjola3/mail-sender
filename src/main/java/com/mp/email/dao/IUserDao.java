package com.mp.email.dao;

import com.mp.email.model.User;

import java.io.IOException;
import java.util.List;

/**
 * Author: Mariola
 */
public interface IUserDao {

    public List<User> findAllUsers() throws IOException;

    public void saveAllUsers(List<User> users);
}
