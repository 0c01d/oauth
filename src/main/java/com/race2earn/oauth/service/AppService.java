package com.race2earn.oauth.service;

import com.race2earn.oauth.domain.App;
import com.race2earn.oauth.web.model.AppRequest;

public interface AppService {

    App findById(Integer id);

    App save(AppRequest appRequest);
}
