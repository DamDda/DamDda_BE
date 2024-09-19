package org.eightbit.damdda.member.repository;

import org.eightbit.damdda.member.domain.Member;
import org.eightbit.damdda.member.dto.RegisterDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Member,Long> {
    public void insertMember(RegisterDTO registerDTO);

}
