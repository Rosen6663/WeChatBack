package com.attend.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckElectives {
    @ApiModelProperty("id")
    private Integer id; // 主键
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("签到地点")
    private String location;
    @ApiModelProperty("打卡图片url")
    private String image;
    @ApiModelProperty("签到时间")
    private LocalDateTime checkTime;
}
