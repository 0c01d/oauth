package com.race2earn.oauth.web;

import com.race2earn.oauth.domain.User;
import com.race2earn.oauth.service.UserService;
import com.race2earn.oauth.web.model.UserRequest;
import com.race2earn.oauth.web.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest, HttpServletResponse response) throws Exception {
        User user = this.userService.save(userRequest);
        response.addHeader(HttpHeaders.LOCATION, "/api/auth/user/" + user.getId());
        return new UserResponse(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        this.userService.delete(id);
    }
}
