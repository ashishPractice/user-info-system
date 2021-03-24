package com.vastika.uis.DAO;

import com.vastika.uis.DTO.UserDTO;
import com.vastika.uis.database.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public UserDAOImpl() {
        // Getting the connection
        con = ConnectionFactory.getConnection();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // To store all user info
        List<UserDTO> users = new ArrayList<UserDTO>();

        try {
            // Query to retrieve all info of user
            String sql = "SELECT * FROM user";

            // Creating prepared statement
            pstmt = con.prepareStatement(sql);

            // executing query
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getLong(4), rs.getDouble(5),
                        rs.getBoolean(6), rs.getDate(7).toLocalDate());
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserDTO searchUserById(int id) {
        UserDTO user = null;

        try {
            String sql = "SELECT * FROM user WHERE id=?";

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getLong(4), rs.getDouble(5),
                        rs.getBoolean(6), rs.getDate(7).toLocalDate());

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public String insertUser(UserDTO user) {
        int count = 0;
        try {

            String sql = "INSERT INTO user(username,password,mobileNo,salary,active,dob) VALUES(?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setLong(3, user.getMobileNo());
            pstmt.setDouble(4, user.getSalary());
            pstmt.setBoolean(5, user.isActive());
            pstmt.setDate(6, Date.valueOf(user.getDob()));


            count = pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return (count > 0) ? "One record insert successfully" : "Problem in inserting data";

    }

    @Override
    public String deleteUser(int id) {
        int rowcount = 0;
        String sql = "DELETE FROM user WHERE id=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rowcount = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (rowcount > 0) ? "One record delete successfully" : "Problem in deletion";
    }

    @Override
    public String updateUserInfo(UserDTO user) {
        int count = 0;
        try {

            String sql = "UPDATE user SET username=?,password=?,mobileNo=?,salary=?,active=?,dob=? WHERE id=?";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setLong(3, user.getMobileNo());
            pstmt.setDouble(4, user.getSalary());
            pstmt.setBoolean(5, user.isActive());
            pstmt.setDate(6, Date.valueOf(user.getDob()));
            pstmt.setInt(7, user.getId());

            count = pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return (count > 0) ? "One record update successfully" : "Problem in updating data";

    }
}
