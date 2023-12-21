package com.university.back.controller;

import com.university.back.model.Form;
import com.university.back.model.Member;
import com.university.back.model.News;
import com.university.back.service.MemberService;
import com.university.back.service.NewsService;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class MemberController {
    private MemberService service;
    private NewsService newsService;

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
    public HashMap<String, String> getMemberData(@RequestParam("sessionId") String sessionId) throws IOException {
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

    @PostMapping(value = "/updateMember", consumes = "multipart/form-data", produces = "application/json")
    public HashMap<String, String> updateMember(@RequestPart("file") @Nullable MultipartFile file, @RequestPart("login") String login, @RequestPart("member") Member member) throws IOException {
        return service.updateMember(login, member, file);
    }
    @GetMapping(value = "/myGroup", produces = "application/json")
    public List<Member> getMembersByGroup(@RequestParam("group") String group) {
        return service.getMembersByGroup(group.toUpperCase());
    }

    @GetMapping(value = "/members", produces = "application/json")
    public List<Member> getAllMembers(@RequestParam("sessionId") String sessionId) {
        return service.getAllMembers(sessionId);
    }

    @GetMapping(value = "/updateNews")
    public void updateNews(@RequestParam("name") News news){
        newsService.updateNewsById(news);
    }

    @GetMapping(value = "/deleteNews")
    public void deleteNews(@RequestParam("id") long id){
        newsService.deleteNewsById(id);
    }

    @GetMapping(value = "getAllNews")
    public List<News> getAllNews(@RequestParam("id") long id){
        return newsService.getAllNews(id);
    }
}