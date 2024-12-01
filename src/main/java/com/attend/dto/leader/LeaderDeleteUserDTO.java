package com.attend.dto.leader;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderDeleteUserDTO {
    @ApiModelProperty("队员id")
    private Integer userId;
    @ApiModelProperty("队长id")
    private Integer adminId;
}
