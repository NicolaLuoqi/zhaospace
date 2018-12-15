package com.shiliu.zhaospace.jpa.repository;

import com.shiliu.zhaospace.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    UserEntity findByUsername(String username);

    UserEntity findByLoginName(String loginName);
}
