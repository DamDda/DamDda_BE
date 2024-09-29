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

    @Override
    public void insertMember(RegisterDTO request) {
        registerRepository.save(request.toEntity());
    }
}