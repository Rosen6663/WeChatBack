package com.attend.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddIntergal {
    private int id;
    private String nickName;
    private Integer integral;
    private Integer experience;
}
