package com.superiority.sovcombankhackathon.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private String password;
    private Date birthday;
    private String phoneNumber;
    private String telegram;
}
