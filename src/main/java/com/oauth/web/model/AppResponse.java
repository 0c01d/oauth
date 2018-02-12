package com.oauth.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oauth.domain.App;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse {
    private Integer id;
    private String secret;
    private String name;

    public AppResponse(App app) {
        this.id = app.getId();
        this.secret = app.getSecret();
        this.name = app.getName();
    }
}
