package com.university.back.service;

import com.university.back.model.Member;
import com.university.back.model.Student;
import com.university.back.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void saveStudent(Student student) {
        repository.saveStudent(student);
    }
    public void deleteStudent(String login) {
        repository.deleteStudent(login);
    }
    public Member getByLogin(String login) {
        return repository.getByLogin(login);
    }
    public void updateStudent(String login, Student updatedStudent) {
        repository.updateMember(login, updatedStudent);
    }
}