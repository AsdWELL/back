package com.university.back.controller;

import com.university.back.model.Student;
import com.university.back.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
@CrossOrigin
public class MemberController {
    private MemberService service;

    @PostMapping(value = "/saveStudent", consumes = {"application/json"})
    public String saveStudent(@RequestBody Student student) {
        return student.getLogin() + " " + student.getName() + " " + student.getSurname();
    }
}