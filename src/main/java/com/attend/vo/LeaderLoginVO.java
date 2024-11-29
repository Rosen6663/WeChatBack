package com.attend.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderLoginVO implements Serializable {
    @ApiModelProperty("签到id")
    private Integer id; // 主键
    @ApiModelProperty("账号")
    private String username; // 主键
    @ApiModelProperty("姓名")
    private String name; // 主键
    @ApiModelProperty("token")
    private String token;

}
