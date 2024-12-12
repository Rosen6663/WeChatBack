package com.attend.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户手机登录数据模型")
public class UserPhoneLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("手机号")
    private String telephone;
    @ApiModelProperty("密码")
    private String password;

}
