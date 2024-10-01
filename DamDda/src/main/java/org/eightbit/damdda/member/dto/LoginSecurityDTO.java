//package org.eightbit.damdda.member.dto;
//
//import lombok.*;
//import org.eightbit.damdda.member.domain.Member;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collection;
//
//@Getter
//public class LoginSecurityDTO extends User {
//
//    private Long id;
//    private String loginId;
//    private String password;
//    private String name;
//    private String email;
//
//    public LoginSecurityDTO(Member member, Collection<? extends GrantedAuthority> authorities) {
//        super(member.getLoginId(), member.getPassword(), authorities);
//        this.id = member.getId();
//        this.loginId = member.getLoginId();
//        this.password = member.getPassword();
//        this.name = member.getName();
//        this.email = member.getEmail();
//    }
//}
