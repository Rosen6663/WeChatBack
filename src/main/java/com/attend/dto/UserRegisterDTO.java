package com.attend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
@ApiModel(description = "用户注册数据模型")
public class UserRegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("头像")
    private String avatar;

}
