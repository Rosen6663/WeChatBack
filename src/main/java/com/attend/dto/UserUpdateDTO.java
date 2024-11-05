package com.attend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
@ApiModel(description = "用户更新数据模型")
public class UserUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("昵称")
    private String nickName;
}
