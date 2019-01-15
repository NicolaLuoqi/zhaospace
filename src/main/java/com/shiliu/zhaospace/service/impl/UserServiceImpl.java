package com.shiliu.zhaospace.service.impl;

import com.shiliu.zhaospace.api.dto.UserDto;
import com.shiliu.zhaospace.jpa.entity.UserEntity;
import com.shiliu.zhaospace.jpa.repository.UserRepository;
import com.shiliu.zhaospace.service.UserService;
import com.shiliu.zhaospace.tran.UserTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findUserByName(String name) {
        return userRepository.findByLoginName(name);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        UserEntity user=userRepository.findByLoginName(userEntity.getLoginName());
        if (user==null){
            userRepository.save(userEntity);
        }
    }

    @Override
    public UserDto getUserInfo(String userId) {
        Optional<UserEntity> optional=userRepository.findById(userId);
        UserEntity userEntity=optional.get();
        return UserTrans.tranInfo(userEntity);
    }

    @Override
    public List<UserDto> getUserInfoList() {
        Sort sort = new Sort(Sort.Direction.ASC, "userNo");
        List<UserEntity> userEntityList=userRepository.findAll(sort);
        return UserTrans.tranList(userEntityList);
    }
}
