package com.shiliu.zhaospace.jpa.repository;

import com.shiliu.zhaospace.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,String> {

    RoleEntity findByRoleNo(String roleNo);
}
