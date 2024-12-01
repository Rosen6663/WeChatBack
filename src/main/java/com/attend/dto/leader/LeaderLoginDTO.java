package com.attend.dto.leader;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "小队长登录数据模型")
public class LeaderLoginDTO {
    @ApiModelProperty("账号")
    private String username; // 主键
    @ApiModelProperty("密码")
    private String password; // 主键
}
