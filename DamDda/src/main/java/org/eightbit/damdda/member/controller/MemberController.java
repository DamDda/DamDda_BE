package org.eightbit.damdda.member.controller;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.member.dto.LoginDTO;
import org.eightbit.damdda.member.dto.MemberDTO;
import org.eightbit.damdda.member.dto.RegisterDTO;
import org.eightbit.damdda.member.service.LoginServiceImpl;
import org.eightbit.damdda.member.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final RegisterService registerService;
    private final LoginServiceImpl loginServiceImpl;

    @PostMapping("/members/profile")
    public String insertMember (@RequestBody RegisterDTO registerDTO){

        try {
            registerService.insertMember(registerDTO);
            return "success";
        } catch (IllegalArgumentException e){
            return "error";
        }
    }

    @PostMapping("/members/login")
    public ResponseEntity<String> login (@RequestBody LoginDTO loginDTO, HttpSession session){
        try {
            MemberDTO memberDTO = loginServiceImpl.login(loginDTO, session);
            return ResponseEntity.ok("welcome" + memberDTO.getLoginId());

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/members/logout")
    public ResponseEntity<String> logout(HttpSession session){
        loginServiceImpl.logout(session);
        return ResponseEntity.ok("logout");
    }
}
