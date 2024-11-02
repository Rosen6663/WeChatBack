package com.attend.vo;
import com.attend.entity.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("获取今日签到信息模型")
public class CheckGetTodayVO implements Serializable {
    @ApiModelProperty("签到签退列表")
    private List<Check> checks;
    @ApiModelProperty("最新一条签到信息")
    private Check check;

}
