package com.race2earn.oauth.repository;

import com.race2earn.oauth.domain.App;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends
        CrudRepository<App, Integer> {
}
