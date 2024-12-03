package com.attend.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "选修课数据模型")
public class XuanxiukeCheckByDTO {
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("签到地点")
    private String location;
    @ApiModelProperty("打卡图片url")
    private String image;
}
