package com.vastika.uis.DTO;

import java.time.LocalDate;

public class UserDTO {

    private int id;
    private String username;
    private String password;
    private long mobileNo;
    private double salary;
    private boolean active;
    private LocalDate dob;

    public UserDTO(int id, String username, String password, long mobileNo, double salary, boolean active, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobileNo = mobileNo;
        this.salary = salary;
        this.active = active;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo=" + mobileNo +
                ", salary=" + salary +
                ", active=" + active +
                ", dob=" + dob +
                '}';
    }
}
