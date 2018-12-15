package com.shiliu.zhaospace.service.impl;

import com.shiliu.zhaospace.jpa.entity.RoleEntity;
import com.shiliu.zhaospace.jpa.repository.RoleRepository;
import com.shiliu.zhaospace.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleEntity saveRole(RoleEntity roleEntity) {
        RoleEntity role=roleRepository.findByRoleNo(roleEntity.getRoleNo());
        if (role==null){
            roleRepository.save(roleEntity);
            return roleEntity;
        }
        return null;
    }
}
