package com.oauth.service;

import com.oauth.domain.OAuthToken;
import com.oauth.domain.User;
import com.oauth.exception.AppCredentialsException;
import com.oauth.exception.InvalidTokenException;
import com.oauth.exception.TokenExpireException;
import com.oauth.exception.UserCredentialsException;
import com.oauth.web.model.OAuthTokenCodeRequest;
import com.oauth.web.model.OAuthTokenInitialRequest;
import com.oauth.web.model.OAuthTokenRefreshRequest;
import com.oauth.web.model.OAuthTokenRequest;

public interface OAuthTokenService {

    OAuthToken create(OAuthTokenInitialRequest oAuthTokenRequest) throws UserCredentialsException;

    OAuthToken findByAppCode(OAuthTokenCodeRequest oAuthTokenCodeRequest) throws AppCredentialsException;

    OAuthToken refresh(OAuthTokenRefreshRequest authTokenRefreshRequest) throws Exception;

    User checkAccessToken(OAuthTokenRequest oAuthTokenRequest) throws TokenExpireException, InvalidTokenException;

    void toStopList(OAuthTokenRequest oAuthTokenRequest) throws TokenExpireException, InvalidTokenException;

    void removeExpiredToken();
}
