package com.university.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Getter
@Table(name = "members")
public class Member {
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "education_group")
    private String group;
    @Column(name = "role")
    private String role;
    @Column(name = "visit_counter")
    private int visitCounter;

    public void increaseVisitCounter() {
        visitCounter++;
    }
    public void refactor() {
        role = "student";
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        visitCounter = 1;
    }
}