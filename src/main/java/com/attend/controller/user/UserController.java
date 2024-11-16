package com.attend.controller.user;

import com.attend.constant.JwtClaimsConstant;
import com.attend.dto.*;
import com.attend.entity.User;
import com.attend.mapper.UserMapper;
import com.attend.properties.JwtProperties;
import com.attend.result.Result;
import com.attend.service.UserService;
import com.attend.utils.JwtUtil;
import com.attend.vo.AllRankingVO;
import com.attend.vo.CheckByTimeVO;
import com.attend.vo.RankingUser;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        if(userUpdateDTO.getAvatar()==null&&userUpdateDTO.getTelephone()==null&&userUpdateDTO.getNickName()==null){
            return Result.success("未进行任何修改");
        }
        userService.update(userUpdateDTO);
        return Result.success("修改成功");
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

    @ApiOperation("获取全部打卡信息")
    @GetMapping("/checkGetAll/{id}")
    public Result<List<Check>> checkGetAll(@PathVariable Long id) {
        log.info("用户{}正在获取今日打卡信息",id);
        List<Check> checks=userService.GetChecksByID(id);
        log.info("查询的打卡信息为:{}",checks);
        return Result.success(checks);
    }
    @ApiOperation("获取今天最新一条打卡信息")
    @GetMapping("/checkNew/{id}")
    public Result<Check> checkNew(@PathVariable Long id) {
        log.info("用户{}正在获取今日打卡信息",id);
        Check check=userMapper.selectTodyCheck(id);
        log.info("查询的最新打卡信息为:{}",check);
        return Result.success(check);
    }

    @ApiOperation("通过时间获取打卡信息")
    @PostMapping("/checkGetByTime")
    public Result<CheckByTimeVO> checkGetByTime(@RequestBody CheckByTimeDTO checkByTimeDTO) {
        log.info("用户正在按照时间查询{}打卡信息",checkByTimeDTO);
        List<Check> checks=userService.GetChecksByTime(checkByTimeDTO);
        log.info("按照时间查询的打卡信息为:{}",checks);
        CheckByTimeVO build = CheckByTimeVO.builder()
                .checkList(checks)
                .num(checks.size())
                .build();

        return Result.success(build);
    }
    /**
     * 排名
     */
    @ApiOperation("获取全部排名")
    @GetMapping("/GetRanking/{id}")
    public Result<AllRankingVO> getExperence(@PathVariable Long id) {
        // 获取全部人员排名和信息
        List<User> users = userMapper.selectUserRank();
        log.info("查询的所有用户；{}", users);

        // 使用AtomicLong来存储number的值
        AtomicLong number = new AtomicLong();

        List<RankingUser> rankingUsers = IntStream.range(0, users.size())
                .mapToObj(index -> {
                    User user = users.get(index);
                    if (user.getId().equals(id)) {
                        number.set(index + 1); // 因为排名是从1开始的，所以加1
                    }
                    return RankingUser.builder()
                            .user(user)
                            .rank(index + 1)
                            .build();
                })
                .collect(Collectors.toList());

        log.info("排名为: {}", rankingUsers);
        log.info("查询排名的用户为: {}", id);

        AllRankingVO allRankingVO = AllRankingVO.builder()
                .rankingUsers(rankingUsers)
                .num(number.get())
                .build();

        return Result.success(allRankingVO);
    }




}
