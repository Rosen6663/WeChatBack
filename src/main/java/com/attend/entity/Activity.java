package com.attend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    private Long id;

    // 活动名称
    private String name;

    // 线上/线下
    private String format;

    // 地点
    private String location;

    // 考研类型
    private String type;

    // 最小参与称号
    private Integer minLevel;

    // 经验奖励
    private Integer expReward;

    // 积分奖励
    private Integer pointReward;

    // 最大参与人数
    private Integer maxParticipants;

    // 活动描述
    private String description;

    // 活动任务
    private String task;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 开始时间
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 结束时间
    private LocalDateTime endTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 作业截止时间
    private LocalDateTime deadline;

    // 状态 '报名中', '进行中', '已结束', '已满员'
    private String status;

    // 创建时间
    private LocalDateTime createdAt;
}
