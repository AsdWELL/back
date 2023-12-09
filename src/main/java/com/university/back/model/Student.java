package com.university.back.model;

import lombok.Getter;
import lombok.ToString;

@Getter
public class Student extends Member{
    private String group;

    public Student(String name, String surname, String group, String login, String password) {
        super(name, surname, login, password, "student");
        this.group = group;
    }
}