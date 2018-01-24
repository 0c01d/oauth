package com.race2earn.oauth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenExpireException extends Exception {

    public TokenExpireException(String message) { super(message); }
}
