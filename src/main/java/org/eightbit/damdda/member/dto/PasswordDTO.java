package org.eightbit.damdda.member.dto;


import lombok.*;

@Getter
@Setter
@ToString
public class PasswordDTO {
    private String currentPassword;
    private String password;
}