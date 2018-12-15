package com.shiliu.zhaospace.startup;

import com.shiliu.zhaospace.jpa.entity.RoleEntity;
import com.shiliu.zhaospace.jpa.entity.UserEntity;
import com.shiliu.zhaospace.service.RoleService;
import com.shiliu.zhaospace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(value = 1)
public class InitData implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        saveUser();
    }

    private void saveUser(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername("赵莉婷");
        userEntity.setLoginName("zhaoLiTing");
        userEntity.setMobile("18664898071");
        userEntity.setEmail("chenliangzlt@sina.com");
        userEntity.setUserNo("1");
        userEntity.setPassword(passwordEncoder.encode("wodemimashi123"));
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setRoleName("admin");
        roleEntity.setRoleNo("10001");
        roleEntity=roleService.saveRole(roleEntity);
        List<RoleEntity> roleEntities=new ArrayList<>();
        roleEntities.add(roleEntity);
        userEntity.setRoleEntities(roleEntities);
        userService.saveUser(userEntity);

    }
}
