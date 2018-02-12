package com.oauth.web.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserTokenRefreshRequest {
    @NotEmpty(message = "Property refreshToken is not set")
    String refreshToken;
}
