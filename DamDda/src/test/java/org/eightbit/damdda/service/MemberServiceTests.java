package org.eightbit.damdda.service;

import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.admin.dto.PageRequestDTO;
import org.eightbit.damdda.admin.dto.PageResponseDTO;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.member.repository.MemberRepository;
import org.eightbit.damdda.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    public void getMember() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(0)
                .size(10)
                .query(null)
                .keyword(null)
                .build();
        PageResponseDTO<MemberDTO> response =
                memberService.findByKeyword(pageRequestDTO);
        log.info(response.getDtoList());
    }

}
