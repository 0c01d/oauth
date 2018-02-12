package com.oauth.service;

import com.oauth.domain.User;
import com.oauth.exception.UserCredentialsException;
import com.oauth.web.model.UserRequest;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    User findByUsername(String username);

    User checkCredentials(String username, String password) throws UserCredentialsException;

    User save(UserRequest userRequest) throws Exception;

    void delete(Long id);
}
