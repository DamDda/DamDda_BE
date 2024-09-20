package org.eightbit.damdda.member.service;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.member.domain.Member;
import org.eightbit.damdda.member.dto.RegisterDTO;
import org.eightbit.damdda.member.repository.RegisterRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;
     private final PasswordEncoder passwordEncoder;

    @Override
    public void insertMember(RegisterDTO registerDTO) {
        Member member = Member.builder()
                .loginId(registerDTO.getLoginId())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .nickname(registerDTO.getNickname())
                .name(registerDTO.getName())
                .email(registerDTO.getEmail())
                .phoneNumber(registerDTO.getPhoneNumber())
                .address(registerDTO.getAddress())
                .detailedAddress(registerDTO.getDetailedAddress())
                .postCode(registerDTO.getPostCode())
                .build();

        registerRepository.save(member);
    }
}