package com.oauth.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oauth.domain.OAuthToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAuthTokenCodeResponse {
    private String code;
    private String redirectUrl;
}