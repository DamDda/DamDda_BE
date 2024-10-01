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
@RequestMapping("/members")
public class MemberController {

    private final RegisterService registerService;
    private final LoginServiceImpl loginServiceImpl;

    @PostMapping("/profile")
    public String insertMember (@RequestBody RegisterDTO registerDTO){

        try {
            registerService.insertMember(registerDTO);
            return "success";
        } catch (IllegalArgumentException e){
            return "error";
        }
    }

    @GetMapping("/profile/idcheck")
    public ResponseEntity<String> checkLoginId(@RequestParam("loginId") String loginId){
        try {
            if (registerService.checkLoginId(loginId)){
                return new ResponseEntity<>("unavailable", HttpStatus.OK);
            }
            return new ResponseEntity<>("available", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/profile/nickname")
    public ResponseEntity<String> checkNickname(@RequestParam("nickname") String nickname){
        try {
            if (registerService.checkNickname(nickname)){
                return new ResponseEntity<>("unavailable", HttpStatus.OK);
            }
            return new ResponseEntity<>("available", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody LoginDTO loginDTO, HttpSession session){
        try {
            MemberDTO memberDTO = loginServiceImpl.login(loginDTO, session);
            return ResponseEntity.ok("welcome" + memberDTO.getLoginId());

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        loginServiceImpl.logout(session);
        return ResponseEntity.ok("logout");
    }
}
