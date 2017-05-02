package com.fernando.proyectofinal.model;

/**
 * Created by Dell on 01/05/2017.
 */

public class Member {
    private String birthDate, name, lastName, email,password;
    private int userId;
    private double earnings;
    private boolean isAssociated;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public boolean isAssociated() {
        return isAssociated;
    }

    public void setAssociated(boolean associated) {
        isAssociated = associated;
    }
}
