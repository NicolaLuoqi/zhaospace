package com.shiliu.zhaospace.tran;

import com.shiliu.zhaospace.api.dto.UserDto;
import com.shiliu.zhaospace.jpa.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserTrans {

    public static List<UserDto> tranList(List<UserEntity> userEntities){
        List<UserDto> userDtos=new ArrayList<>();
        for (UserEntity userEntity:userEntities){
            UserDto userDto=tranInfo(userEntity);
            userDtos.add(userDto);
        }

        return userDtos;
    }

    public static UserDto tranInfo(UserEntity userEntity){
        UserDto userDto=new UserDto();
        userDto.setUserId(userEntity.getId());
        userDto.setUserNo(userEntity.getUserNo());
        userDto.setUserName(userEntity.getUsername());
        userDto.setUserEmail(userEntity.getEmail());
        userDto.setUserMobil(userEntity.getMobile());
        userDto.setCreateDate(userEntity.getCreateTime().toString());
        return userDto;
    }
}
