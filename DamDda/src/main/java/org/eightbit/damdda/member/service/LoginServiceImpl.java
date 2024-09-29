package org.eightbit.damdda.member.service;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.admin.repository.MemberRepository;
import org.eightbit.damdda.member.domain.Member;
import org.eightbit.damdda.member.dto.LoginDTO;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.member.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService{

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public MemberDTO login(LoginDTO loginDTO, HttpSession session) {
        Optional<Member> member = loginRepository.findByLoginIdAndPassword(loginDTO.getLoginId(), loginDTO.getPassword());
        if(member.isPresent()) {
            session.setAttribute("loginMember", member.get());
            return MemberDTO.of(member.get());
        }else {
            throw new IllegalArgumentException("error");
        }
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @Override
    public void searchId() {

    }
}
