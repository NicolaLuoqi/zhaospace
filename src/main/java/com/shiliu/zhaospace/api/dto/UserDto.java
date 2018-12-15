package com.shiliu.zhaospace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private String userId;

    private String userNo;

    private String userName;

    private String userMobil;

    private String userEmail;

    private String createDate;

}
