package com.attend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "用户按时间打卡")
public class CheckByTimeDTO implements Serializable {
    @ApiModelProperty("查询用户的id")
    private String id;
    @ApiModelProperty("查询日期")
    private LocalDate selectDate; // 签到时间



}
