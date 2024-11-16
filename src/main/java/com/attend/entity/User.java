package com.attend.entity;

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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    //微信用户唯一标识
    private String openid;
    //昵称
    private String nickName;

    //头像
    private String avatar;
    //经验
    private Double experience;
    //注册时间
    private LocalDateTime createTime;

    private String telephone;
}
