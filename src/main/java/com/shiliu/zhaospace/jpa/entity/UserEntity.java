package com.shiliu.zhaospace.jpa.entity;

import com.shiliu.zhaospace.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "system_user")
@Getter
@Setter
public class UserEntity extends BaseEntity{

    private String userNo;

    private String username;

    private String loginName;

    private String password;

    private String mobile;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "system_user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<RoleEntity> roleEntities;

}
