package com.attend.dto.leader;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户更新数据模型")
public class UserUpadteIntegralDTO {
    @ApiModelProperty("队长id")
    private Long id;
    @ApiModelProperty("队员id")
    private Long userId;
    @ApiModelProperty("积分")
    private Integer integral;
}
