package com.race2earn.oauth.service;

import com.race2earn.oauth.domain.User;
import com.race2earn.oauth.exception.UserCredentialsException;
import com.race2earn.oauth.web.model.UserRequest;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    User findByUsername(String username);

    User checkCredentials(String username, String password) throws UserCredentialsException;

    User save(UserRequest userRequest) throws Exception;

    void delete(Integer id);
}
