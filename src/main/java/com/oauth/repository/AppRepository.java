package com.oauth.repository;

import com.oauth.domain.App;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends
        CrudRepository<App, Integer> {
}
