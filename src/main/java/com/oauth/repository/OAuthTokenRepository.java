package com.oauth.repository;

import com.oauth.domain.OAuthToken;
import org.springframework.data.repository.CrudRepository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OAuthTokenRepository extends
        CrudRepository<OAuthToken, String> {

    Optional<OAuthToken> findByAppCode(String appCode);

    List<OAuthToken> findAllByAccessExpiresBeforeOrRefreshExpiresBefore(Date accessExpired, Date refreshExpired);
}
