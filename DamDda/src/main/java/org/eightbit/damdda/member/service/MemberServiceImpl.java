package org.eightbit.damdda.member.service;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.member.domain.Member;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDTO getMember(String loginId) {
        Optional<Member> member = memberRepository.findByLoginId(loginId);
        if (member.isPresent()) {
            return MemberDTO.of(member.get());
        }else {
            return null;
        }
    }
}
