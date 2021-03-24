package com.vastika.uis.service;

import com.vastika.uis.DAO.UserDAO;
import com.vastika.uis.DAO.UserDAOImpl;
import com.vastika.uis.DTO.UserDTO;

import java.util.List;

public class UserServiceImpl implements UserService{

    UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public UserDTO searchUserById(int id) {
        return userDAO.searchUserById(id);
    }

    @Override
    public String insertUser(UserDTO user) {
        return userDAO.insertUser(user);
    }

    @Override
    public String deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public String updateUserInfo(UserDTO user) {
        return userDAO.updateUserInfo(user);
    }
}
