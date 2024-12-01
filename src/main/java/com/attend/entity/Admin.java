package com.attend.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @ApiModelProperty("签到id")
    private Integer id; // 主键
    @ApiModelProperty("账号")
    private String username; // 主键
    @ApiModelProperty("密码")
    private String password; // 主键
    @ApiModelProperty("姓名")
    private String name; // 主键
    @ApiModelProperty("角色id")
    private Integer roleId; // 主键
}
