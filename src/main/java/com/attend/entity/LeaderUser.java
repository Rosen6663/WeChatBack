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
public class LeaderUser {
    @ApiModelProperty("id")
    private Integer id; // 主键
    @ApiModelProperty("队员id")
    private Integer userId;
    @ApiModelProperty("队长id")
    private Integer adminId;
}
