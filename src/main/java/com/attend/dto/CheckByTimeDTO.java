package com.attend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "用户按时间打卡")
public class CheckByTimeDTO implements Serializable {
    @ApiModelProperty("查询用户的id")
    private String id;
    @ApiModelProperty("开始时间")
    private LocalDateTime startTime; // 签到时间
    @ApiModelProperty("结束时间")
    private LocalDateTime endTime; // 签退时间


}
