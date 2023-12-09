package com.university.back.repository;

import com.university.back.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MemberRepository {
    private final List<Member> MEMBERS;

    public void saveStudent(Member member) {
        MEMBERS.add(member);
    }
    public void deleteStudent(String login) {
        MEMBERS.remove(getByLogin(login));
    }
    public Member getByLogin(String login) {
        return MEMBERS.stream()
                .filter(member -> member.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }
    public void updateMember(String login, Member updatedMember) {
        deleteStudent(login);
        saveStudent(updatedMember);
    }
}
