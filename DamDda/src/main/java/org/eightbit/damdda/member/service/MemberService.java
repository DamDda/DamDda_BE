package org.eightbit.damdda.member.service;

import org.eightbit.damdda.member.dto.MemberDTO;
import org.springframework.ui.Model;

public interface MemberService {
    MemberDTO getMember(String loginId);
}
