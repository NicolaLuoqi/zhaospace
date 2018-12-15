package com.shiliu.zhaospace.service;

import com.shiliu.zhaospace.api.dto.UserDto;
import com.shiliu.zhaospace.jpa.entity.UserEntity;

public interface UserService {

    UserEntity findUserByName(String name);

    void saveUser(UserEntity userEntity);

    UserDto getUserInfo(String userId);
}
