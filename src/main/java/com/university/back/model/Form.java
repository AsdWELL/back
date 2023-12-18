package com.university.back.model;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class Form {
    private String login;
    private Member member;
    private MultipartFile file;
}