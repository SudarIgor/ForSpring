package com.example.springbasic.services;

import com.example.springbasic.model.Product;
import com.example.springbasic.model.User;
import com.example.springbasic.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findById(long id) {
        return userDAO.findById(id);
    }

    public List<Product> showProducts(long id) {
        return userDAO.showProducts(id);
    }
}
