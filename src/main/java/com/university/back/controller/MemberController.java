package com.university.back.controller;

import com.university.back.model.Member;
import com.university.back.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
@CrossOrigin
public class MemberController {
    private MemberService service;

    @PostMapping(value = "/saveStudent", consumes = {"application/json"}, produces = "application/json")
    public HashMap<String, String> saveMember(@RequestBody Member member) {
        return service.saveMember(member);
    }

    @PostMapping(value = "/checkMember", consumes = {"application/x-www-form-urlencoded"}, produces ="application/json")
    public HashMap<String, String> checkMember(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("visit") boolean visit) {
        return service.checkMember(login, password, visit);
    }

    @GetMapping(value = "/date", produces = "application/x-www-form-urlencoded")
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        return LocalDateTime.now().format(formatter);
    }
}