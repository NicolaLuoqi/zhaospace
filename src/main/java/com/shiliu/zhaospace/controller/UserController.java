package com.shiliu.zhaospace.controller;

import com.shiliu.zhaospace.api.client.UserClient;
import com.shiliu.zhaospace.api.dto.UserDto;
import com.shiliu.zhaospace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements UserClient {

    @Autowired
    private UserService userService;

    @Override
    public UserDto getUserInfo(String userId) {
        return userService.getUserInfo(userId);
    }
}
