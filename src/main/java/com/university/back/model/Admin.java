package com.university.back.model;

public class Admin extends Member{
    public Admin(String name, String surname, String group, String login, String password) {
        super(name, surname, login, password, "admin");
    }
}
