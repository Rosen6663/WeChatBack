package com.attend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
@ApiModel(description = "用户登录数据模型")
public class UserLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("微信授权码")
    private String code;

}
