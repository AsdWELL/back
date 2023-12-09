package com.university.back.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Member {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;
}
