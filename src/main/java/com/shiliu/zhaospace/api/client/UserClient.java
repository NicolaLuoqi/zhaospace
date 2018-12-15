package com.shiliu.zhaospace.api.client;

import com.shiliu.zhaospace.api.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "api/user")
public interface UserClient {

    @GetMapping(value = "getUserInfo")
    UserDto getUserInfo(@RequestParam("userId") String userId);
}
