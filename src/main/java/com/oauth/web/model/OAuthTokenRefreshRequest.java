package com.oauth.web.model;

import lombok.Data;

@Data
public class OAuthTokenRefreshRequest {
    private String refreshToken;
}
