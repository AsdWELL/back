package com.university.back.controller;

import com.university.back.model.Member;
import com.university.back.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
@CrossOrigin
public class MemberController {
    private MemberService service;

    @PostMapping(value = "/saveStudent", consumes = {"application/json"}, produces = "application/json")
    public HashMap<String, String> saveMember(@RequestBody Member member) {
        member.refactor();
        return service.saveMember(member);
    }

    @PostMapping(value = "/checkMember", consumes = {"application/x-www-form-urlencoded"}, produces ="application/json")
    public HashMap<String, String> checkMember(@RequestParam("login") String login, @RequestParam("password") String password) {
        return service.checkMember(login, password);
    }
}