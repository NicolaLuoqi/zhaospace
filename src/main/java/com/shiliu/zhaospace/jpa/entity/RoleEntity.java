package com.shiliu.zhaospace.jpa.entity;

import com.shiliu.zhaospace.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "system_role")
@Getter
@Setter
public class RoleEntity extends BaseEntity{

    private String roleName;

    private String roleNo;
}
