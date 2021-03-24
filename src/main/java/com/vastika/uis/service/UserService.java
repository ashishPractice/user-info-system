package com.vastika.uis.service;

import com.vastika.uis.DTO.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> getAllUsers();

    public UserDTO searchUserById(int id);

    public String insertUser(UserDTO user);

    public String deleteUser(int id);

    public String updateUserInfo(UserDTO user);
}
