package com.shiliu.zhaospace.controller;

import com.shiliu.zhaospace.api.dto.UserDto;
import com.shiliu.zhaospace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public String  getUser(@PathVariable String id, Model model) {
        UserDto userDto=userService.getUserInfo(id);
        model.addAttribute("user",userDto);
        return "/user/detail";
    }

    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<UserDto> userList = userService.getUserInfoList();
        model.addAttribute("users", userList);
        return "user/list";
    }

}
