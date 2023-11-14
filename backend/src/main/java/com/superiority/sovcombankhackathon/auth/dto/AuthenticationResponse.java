package com.superiority.sovcombankhackathon.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private Integer userId;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private Date birthday;
    private String phoneNumber;
    private String telegram;
    private String role;
}