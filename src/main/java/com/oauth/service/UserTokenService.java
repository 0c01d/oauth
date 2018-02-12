package com.oauth.service;

import com.oauth.domain.User;
import com.oauth.domain.UserToken;
import com.oauth.exception.InvalidTokenException;
import com.oauth.exception.TokenExpireException;
import com.oauth.exception.UserCredentialsException;
import com.oauth.web.model.UserTokenRequest;
import com.oauth.web.model.UserTokenInitialRequest;
import com.oauth.web.model.UserTokenRefreshRequest;

public interface UserTokenService {

    UserToken create(UserTokenInitialRequest userTokenInitialRequest) throws UserCredentialsException;

    UserToken refresh(UserTokenRefreshRequest userTokenRefreshRequest) throws TokenExpireException, InvalidTokenException;

    User checkAccessToken(UserTokenRequest userTokenRequest) throws TokenExpireException, InvalidTokenException;

    void delete(UserTokenRequest userTokenRequest);

    void removeExpiredToken();
}
