package com.university.back.repository;

import com.university.back.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, String> {
    void deleteMemberByLogin(String login);

    Member findMemberByLogin(String login);
}
