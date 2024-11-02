package com.attend.controller.user;

import com.attend.constant.JwtClaimsConstant;
import com.attend.dto.CheckDTO;
import com.attend.dto.UserLoginDTO;
import com.attend.dto.UserRegisterDTO;
import com.attend.dto.UserUpdateDTO;
import com.attend.entity.User;
import com.attend.mapper.UserMapper;
import com.attend.properties.JwtProperties;
import com.attend.result.Result;
import com.attend.service.UserService;
import com.attend.utils.JwtUtil;
import com.attend.vo.CheckGetTodayVO;
import com.attend.vo.UserLoginVO;
import com.attend.entity.Check;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("userController")
@RequestMapping("/user/user")
@Slf4j
@Api(tags = "C端用户相关接口")
public class UserController {
    //微信登录
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录注册
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("微信登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
       log.info("微信登录：{}", userLoginDTO);
        User user = userService.login(userLoginDTO);
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .openid(user.getOpenid())
                .token(token)
                .build();
        log.info("返回:{}",userLoginVO);
        return Result.success(userLoginVO);
    }
    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public Result<String> logout() {
        return Result.success();
    }
    //判断用户是否注册
    @GetMapping("/register/{id}")
    @ApiOperation("根据id查询用户名是否存在,判断用户是否注册")
    public Result<String> info(@PathVariable Long id) {
        log.info("根据id查询姓名是否存在,判断用户是否注册:{}",id);
        String nickName = userService.getById(id);
        return Result.success(nickName);
    }
    //接收注册信息
    @PutMapping("/register")
    @ApiOperation("接收注册信息")
    public Result<String> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("接收注册信息:{}",userRegisterDTO);
        userService.update(userRegisterDTO);
        return Result.success();
    }

    /**
     * 用户信息
     * @param id
     * @return
     */
    //获取用户信息
    @GetMapping("/{id}")
    @ApiOperation("获取用户信息")
    public Result<User> info(@PathVariable long id) {
        log.info("获取用户信息:{}",id);
        User user = userService.info(id);
        return Result.success(user);
    }
    //更新用户信息
    @PutMapping("/update")
    @ApiOperation("更新用户信息")
    public Result<String> update(@RequestBody UserUpdateDTO userUpdateDTO) {
        log.info("更新用户信息:{}",userUpdateDTO);
        userService.update(userUpdateDTO);
        return Result.success();
    }

    /**
     * 签到签退记录
     */
    //签到
    @PostMapping("/checkIn")
    @ApiOperation("签到")
    public Result<String> checkIn(@RequestBody CheckDTO checkDTO) {
        log.info("接收签到用户:{},打卡地点为：{}",checkDTO.getId(),checkDTO.getLocation());
        String resulet= userService.checkIn(checkDTO);
        return Result.success(resulet);
    }
    //签退
    @PostMapping("/checkOut")
    @ApiOperation("签退")
    public Result<String> checkOut(@RequestBody CheckDTO checkDTO) {
        log.info("接收签退用户:{},打卡地点为：{}",checkDTO.getId(),checkDTO.getLocation());
        String resulet= userService.checkOut(checkDTO);
        return Result.success(resulet);
    }

    @ApiOperation("获取今日签到签退信息")
    @GetMapping("/checkGetToday/{id}")
    public Result<CheckGetTodayVO> checkGetToday(@PathVariable Long id) {
        log.info("用户{}正在获取今日打卡信息",id);
        List<Check> checks=userService.GetChecksByID(id);
        log.info("查询的打卡信息为:{}",checks);

        Check check=userMapper.selectTodyCheck(id);
        log.info("查看最新的一条签到信息{}",check);

        CheckGetTodayVO checkGetTodayVO= CheckGetTodayVO.builder()
                .check(check)
                .checks(checks)
                .build();

        return Result.success(checkGetTodayVO);
    }
    /**
     * 排名
     */



}
