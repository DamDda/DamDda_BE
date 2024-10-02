package org.eightbit.damdda.member.dto;


import lombok.*;
import org.eightbit.damdda.member.domain.Member;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    private String loginId;
    private String password;
    private String nickname;
    private String name;
    private String email;
    private String phoneNumber;
    private String imageUrl;

    public static MemberDTO of(Member member) {
        return MemberDTO.builder()
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .name(member.getName())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .imageUrl(member.getImageUrl())
                .build();
    }

}
