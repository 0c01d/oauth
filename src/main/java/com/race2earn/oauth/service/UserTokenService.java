package com.race2earn.oauth.service;

import com.race2earn.oauth.domain.User;
import com.race2earn.oauth.domain.UserToken;
import com.race2earn.oauth.exception.InvalidTokenException;
import com.race2earn.oauth.exception.TokenExpireException;
import com.race2earn.oauth.exception.UserCredentialsException;
import com.race2earn.oauth.web.model.UserTokenRequest;
import com.race2earn.oauth.web.model.UserTokenInitialRequest;
import com.race2earn.oauth.web.model.UserTokenRefreshRequest;

public interface UserTokenService {

    UserToken create(UserTokenInitialRequest userTokenInitialRequest) throws UserCredentialsException;

    UserToken refresh(UserTokenRefreshRequest userTokenRefreshRequest) throws TokenExpireException, InvalidTokenException;

    User checkAccessToken(UserTokenRequest userTokenRequest) throws TokenExpireException, InvalidTokenException;

    void delete(UserTokenRequest userTokenRequest);

    void removeExpiredToken();
}
