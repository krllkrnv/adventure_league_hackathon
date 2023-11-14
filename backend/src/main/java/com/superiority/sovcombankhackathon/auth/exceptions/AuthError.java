package com.superiority.sovcombankhackathon.auth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthError {
    private String message;
}

