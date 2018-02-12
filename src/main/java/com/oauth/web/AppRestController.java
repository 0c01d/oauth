package com.oauth.web;

import com.oauth.domain.App;
import com.oauth.service.AppService;
import com.oauth.web.model.AppRequest;
import com.oauth.web.model.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/app")
public class AppRestController {

    private final AppService appService;

    @Autowired
    public AppRestController(AppService appService) {
        this.appService = appService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public AppResponse createApp(@Valid @RequestBody AppRequest appRequest, HttpServletResponse response) {
        App app = this.appService.save(appRequest);
        response.addHeader(HttpHeaders.LOCATION, "/api/auth/app/" + app.getId());
        return new AppResponse(app);
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AppResponse getApp(@PathVariable Integer id) {
        return new AppResponse(appService.findById(id));
    }
}
