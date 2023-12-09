package com.university.back.model;

public class Teacher extends Member{
    public Teacher(String name, String surname, String group, String login, String password) {
        super(name, surname, login, password, "teacher");
    }
}
