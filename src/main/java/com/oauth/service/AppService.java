package com.oauth.service;

import com.oauth.domain.App;
import com.oauth.web.model.AppRequest;

public interface AppService {

    App findById(Integer id);

    App save(AppRequest appRequest);
}
