package com.university.back.service;

import com.university.back.model.Member;
import com.university.back.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class MemberService{
    private MemberRepository repository;

    public HashMap<String, String> saveMember(Member member) {
        HashMap<String, String> response = new HashMap<>();
        member.refactor();
        if (repository.findMemberByLogin(member.getLogin()) == null) {
            member.setSessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
            response.put("sessionId", member.getSessionId());
            repository.save(member);
        }
        else
            response.put("error_login", "Данный логин уже занят");
        return response;
    }
    public HashMap<String, String> checkMember(String login, String password) {
        HashMap<String, String> response = new HashMap<>();
        var member = repository.findMemberByLogin(login);
        if (member == null) {
            response.put("error_login", "Неправильный логин");
            return response;
        }
        if (member.getPassword().equals(password)) {
            member.increaseVisitCounter();
            member.setSessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
            repository.save(member);
            response.put("sessionId", member.getSessionId());
        }
        else
            response.put("error_password", "Неправильный пароль");
        return response;
    }
    public void deleteMember(String login) {
        repository.deleteMemberByLogin(login);
    }
    public Member getMemberByLogin(String login) {
        return repository.findMemberByLogin(login);
    }
    public Member getMemberBySessionId(String sessionId) {
        return repository.findMemberBySessionId(sessionId);
    }

    public HashMap<String, String> getMemberData(Member member) {
        HashMap<String, String> response = new HashMap<>();
        response.put("name", member.getName());
        response.put("surname", member.getSurname());
        response.put("login", member.getLogin());
        response.put("group", member.getGroup());
        response.put("role", member.getRole());
        response.put("counter", String.valueOf(member.getVisitCounter()));
        return response;
    }
}