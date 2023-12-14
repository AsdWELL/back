package com.university.back.service;

import com.university.back.model.Member;
import com.university.back.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public HashMap<String, String> saveMember(Member member) {
        HashMap<String, String> response = new HashMap<>();
        member.refactor();
        if (repository.findMemberByLogin(member.getLogin()) == null) {
            repository.save(member);
            setMemberData(response, member);
        }

        else
            response.put("error_login", "Данный логин уже занят");
        return response;
    }
    public HashMap<String, String> checkMember(String login, String password, boolean visit) {
        HashMap<String, String> response = new HashMap<>();
        var member = repository.findMemberByLogin(login);
        if (member == null) {
            response.put("error_login", "Неправильный логин");
            return response;
        }
        if (member.getPassword().equals(password)) {
            if (visit)
                member.increaseVisitCounter();
            repository.save(member);
            setMemberData(response, member);
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

    private void setMemberData(HashMap<String, String> response, Member member) {
        response.put("name", member.getName());
        response.put("surname", member.getSurname());
        response.put("login", member.getLogin());
        response.put("password", member.getPassword());
        response.put("group", member.getGroup());
        response.put("role", member.getRole());
    }
}