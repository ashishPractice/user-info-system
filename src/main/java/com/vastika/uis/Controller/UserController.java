package com.vastika.uis.Controller;

import com.vastika.uis.DTO.UserDTO;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    public UserDTO getUser(String type) {
        int id = 0;
        if (type.equals("update")) {
            id = Integer.parseInt(JOptionPane.showInputDialog("Enter user id:"));
        }
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        long mobile = Long.parseLong(JOptionPane.showInputDialog("Enter mobile:"));
        Double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:"));
        boolean active = Boolean.parseBoolean(JOptionPane.showInputDialog("Active:"));
        String sDate = JOptionPane.showInputDialog("Date<yyyy-mm-dd>:");
        LocalDate dob = LocalDate.parse(sDate);

        UserDTO user = new UserDTO(id, username, password, mobile, salary, active, dob);

        return user;
    }

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        String result = "";
        UserController userCon = new UserController();

        while (true) {
            int choice = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter your choice:: \n 1. Get all user info \n 2. Search user by id "
                            + "\n 3. Insert new user \n 4. Update user info \n 5. Delete user \n 6. Exit"));

            switch (choice) {
                case 1:
                    result = "";
                    List<UserDTO> users = new ArrayList<UserDTO>();

                    users = userService.getAllUsers();

                    for (UserDTO user : users) {

                        result = result + "UserId: " + user.getId() + "\nUserName: " + user.getUsername() + "\nPassword: "
                                + user.getPassword() + "\nMobile Num: " + user.getMobileNo() + "\nSalary: " + user.getSalary()
                                + "\nActive: " + user.isActive() + "\nDOB: " + user.getDob() + "\n\n";

                    }

                    JOptionPane.showMessageDialog(null, result);

                    break;

                case 2:
                    result = "";

                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id to search:"));

                    UserDTO user = userService.searchUserById(id);

                    if (user != null) {

                        result = result + "UserId: " + user.getId() + "\nUserName: " + user.getUsername() + "\nPassword: "
                                + user.getPassword() + "\nMobile Num: " + user.getMobileNo() + "\nSalary: " + user.getSalary()
                                + "\nActive: " + user.isActive() + "\nDOB: " + user.getDob() + "\n\n";

                        JOptionPane.showMessageDialog(null, result);
                    } else {
                        JOptionPane.showMessageDialog(null, "Search not found");
                    }
                    break;

                case 3:
                    result = "";

                    UserDTO user1 = userCon.getUser("insert");

                    result = userService.insertUser(user1);

                    JOptionPane.showMessageDialog(null, result);

                    break;

                case 4:

                    result = "";

                    UserDTO user2 = userCon.getUser("update");

                    result = userService.updateUserInfo(user2);

                    JOptionPane.showMessageDialog(null, result);

                    break;

                case 5:
                    result = "";

                    int user_id = Integer.parseInt(JOptionPane.showInputDialog("Enter user Id:"));

                    result = userService.deleteUser(user_id);

                    JOptionPane.showMessageDialog(null, result);

                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }

    }

}
