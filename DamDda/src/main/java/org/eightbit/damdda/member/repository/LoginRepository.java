package org.eightbit.damdda.member.repository;

import org.eightbit.damdda.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Member, Long> {
    public Member findByEmail(String email);
    public void login();
    public void logout();
    public String searchId();
}
