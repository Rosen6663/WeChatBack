package com.attend.dto.leader;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "小队长添加队员模型")
public class LeaderAddUserDTO {
    @ApiModelProperty("队长id")
    private Integer adminId; // 主键
    @ApiModelProperty("队员id")
    private String userId; // 主键
}
