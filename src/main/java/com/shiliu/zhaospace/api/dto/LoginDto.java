package com.shiliu.zhaospace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements Serializable {

    String imgAddress;

    String loginAddress;

    @NotEmpty(message = "用户名不能为空！")
    String userName;

    @NotEmpty(message = "密码不能为空！")
    String passWard;

    String message;

}
