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

    @PostMapping(value = "/saveStudent", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> saveMember(@RequestBody Member member) {
        return service.saveMember(member);
    }

    @PostMapping(value = "/checkMember", consumes = "application/x-www-form-urlencoded", produces ="application/json")
    public HashMap<String, String> checkMember(@RequestParam("login") String login, @RequestParam("password") String password) {
        return service.checkMember(login, password);
    }

    @GetMapping(value = "/checkSession", produces = "application/x-www-form-urlencoded")
    public String checkSessionId(@RequestParam("sessionId") String sessionId) {
        return String.valueOf(service.getMemberBySessionId(sessionId) != null);
    }

    @GetMapping(value = "/memberData", produces = "application/json")
    public HashMap<String, String> getMemberData(@RequestParam("sessionId") String sessionId) {
        var member = service.getMemberBySessionId(sessionId);
        if (member == null)
            return null;
        return service.getMemberData(member);
    }

    @GetMapping(value = "/date", produces = "application/x-www-form-urlencoded")
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        return LocalDateTime.now().format(formatter);
    }
}