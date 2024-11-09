package com.attend.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Check implements Serializable {
        private static final long serialVersionUID = 1L;
        @ApiModelProperty("签到id")
        private Integer id; // 主键
        @ApiModelProperty("签到时间")
        private LocalDateTime checkInTime; // 签到时间
        @ApiModelProperty("签退时间")
        private LocalDateTime checkOutTime; // 签退时间
        @ApiModelProperty("签到地点")
        private String checkInLocation; // 签到地点
        @ApiModelProperty("签退地点")
        private String checkOutLocation; // 签退地点
        @ApiModelProperty("今日打卡次数")
        private Integer roundNumber; // 第几轮
        @ApiModelProperty("签到用户id")
        private Long userId;
        @ApiModelProperty("获得经验")
        private Double experience;
}
