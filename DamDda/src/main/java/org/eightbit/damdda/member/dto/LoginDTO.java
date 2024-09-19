package org.eightbit.damdda.member.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginDTO {
    private String loginId;
    private String password;
    private String name;
    private String email;
}
