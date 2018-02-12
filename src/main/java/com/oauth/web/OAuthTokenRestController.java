package com.oauth.web;

import com.oauth.domain.OAuthToken;
import com.oauth.exception.AppCredentialsException;
import com.oauth.exception.InvalidTokenException;
import com.oauth.exception.TokenExpireException;
import com.oauth.exception.UserCredentialsException;
import com.oauth.service.OAuthTokenService;
import com.oauth.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/oauth")
public class OAuthTokenRestController {

    private final OAuthTokenService oAuthTokenService;

    @Autowired
    public OAuthTokenRestController(OAuthTokenService oAuthTokenService) {
        this.oAuthTokenService = oAuthTokenService;
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public OAuthTokenCodeResponse createToken(@Valid @RequestBody OAuthTokenInitialRequest tokenRequest) throws UserCredentialsException {
        OAuthToken token = this.oAuthTokenService.create(tokenRequest);
        return new OAuthTokenCodeResponse(token.getAppCode(), tokenRequest.getRedirectUrl());
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public OAuthTokenResponse getToken(@Valid @RequestBody OAuthTokenCodeRequest codeRequest) throws AppCredentialsException {
        return new OAuthTokenResponse(this.oAuthTokenService.findByAppCode(codeRequest));
    }

    @RequestMapping(value = "/token/refresh", method = RequestMethod.POST)
    public OAuthTokenResponse getToken(@Valid @RequestBody OAuthTokenRefreshRequest refreshRequest) throws Exception {
        return new OAuthTokenResponse(this.oAuthTokenService.refresh(refreshRequest));
    }

    @RequestMapping(value = "/token/check", method = RequestMethod.POST)
    public UserResponse checkToken(@Valid @RequestBody OAuthTokenRequest tokenRequest) throws TokenExpireException, InvalidTokenException {
        return new UserResponse(this.oAuthTokenService.checkAccessToken(tokenRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/token", method = RequestMethod.DELETE)
    public void deleteToken(@Valid @RequestBody OAuthTokenRequest tokenRequest) throws TokenExpireException, InvalidTokenException {
        this.oAuthTokenService.toStopList(tokenRequest);
    }
}
