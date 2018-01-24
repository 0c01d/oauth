package com.race2earn.oauth.service;

import com.race2earn.oauth.domain.OAuthToken;
import com.race2earn.oauth.domain.User;
import com.race2earn.oauth.exception.AppCredentialsException;
import com.race2earn.oauth.exception.InvalidTokenException;
import com.race2earn.oauth.exception.TokenExpireException;
import com.race2earn.oauth.exception.UserCredentialsException;
import com.race2earn.oauth.web.model.OAuthTokenCodeRequest;
import com.race2earn.oauth.web.model.OAuthTokenInitialRequest;
import com.race2earn.oauth.web.model.OAuthTokenRefreshRequest;
import com.race2earn.oauth.web.model.OAuthTokenRequest;

public interface OAuthTokenService {

    OAuthToken create(OAuthTokenInitialRequest oAuthTokenRequest) throws UserCredentialsException;

    OAuthToken findByAppCode(OAuthTokenCodeRequest oAuthTokenCodeRequest) throws AppCredentialsException;

    OAuthToken refresh(OAuthTokenRefreshRequest authTokenRefreshRequest) throws Exception;

    User checkAccessToken(OAuthTokenRequest oAuthTokenRequest) throws TokenExpireException, InvalidTokenException;

    void toStopList(OAuthTokenRequest oAuthTokenRequest) throws TokenExpireException, InvalidTokenException;

    void removeExpiredToken();
}
