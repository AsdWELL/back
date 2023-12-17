package com.university.back.repository;

import com.university.back.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    void deleteMemberByLogin(String login);
    Member findMemberByLogin(String login);
    List<Member> findAllByGroup(String group);
    Member findMemberBySessionId(String sessionId);
}
