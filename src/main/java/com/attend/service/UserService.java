package com.attend.service;


import com.attend.dto.user.*;
import com.attend.entity.User;
import com.attend.entity.Check;

import java.util.List;

public interface UserService {



    //登录
    User login(UserLoginDTO userLoginDTO);
    //根据用户id查询用户信息
    User info(Long id);
    //更新用户信息
    void update(UserUpdateDTO userUpdateDTO);
    //查询姓名是否存在
    String getById(Long id);
    //接收注册信息
    void update(UserRegisterDTO userRegisterDTO);
    //签到
    String checkIn(CheckDTO checkDTO);
    //签退
    String checkOut(CheckDTO checkDTO);

    List<Check> GetChecksByID(Long id);

    List<Check> GetChecksByTime(CheckByTimeDTO checkByTimeDTO);

    void insertElectivesCheck(XuanxiukeCheckByDTO xuanxiukeCheckByDTO);

    User loginPhone(UserPhoneLoginDTO userPhoneLoginDTO);
}
