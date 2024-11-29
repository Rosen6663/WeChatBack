package com.attend.controller.admin.leader;

import com.attend.constant.JwtClaimsConstant;
import com.attend.dto.LeaderLoginDTO;
import com.attend.dto.UserUpadteExperienceDTO;
import com.attend.dto.UserUpadteIntegralDTO;
import com.attend.entity.Leader;
import com.attend.mapper.LeaderMapper;
import com.attend.properties.JwtProperties;
import com.attend.result.Result;
import com.attend.service.LeaderService;
import com.attend.utils.JwtUtil;
import com.attend.vo.LeaderLoginVO;
import com.attend.vo.UserAddIntergal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin
@RestController("LeaderController")
@RequestMapping("/api/admin/leader")
@Slf4j
@Api(tags = "小队长相关接口")
public class LeaderController {
    @Autowired
    LeaderService leaderService;
    @Autowired
    JwtProperties jwtProperties;
    @Autowired
    private LeaderMapper leaderMapper;

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<LeaderLoginVO> login(@RequestBody LeaderLoginDTO leaderLoginDTO) {
        log.info("用户登录：{}",leaderLoginDTO);

        Leader leader = leaderService.login(leaderLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, leader.getId());
        val token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        LeaderLoginVO leaderLoginVO = LeaderLoginVO.builder()
                .id(leader.getId())
                .username(leader.getUsername())
                .name(leader.getName())
                .token(token)
                .build();

        return Result.success(leaderLoginVO);


    }
    @GetMapping("/getAllNickName")
    @ApiOperation("查询所有新生姓名")
    public Result<List<UserAddIntergal>> getAllUserNickName(Integer id,String name) {
        log.info("小队长:{},{}进行查询",name,id);
        List<UserAddIntergal> userAddIntergals= leaderMapper.getAllNickName();

        return Result.success(userAddIntergals) ;
    }

    @PostMapping("/updateUserIntegral")
    @ApiOperation("更新用户积分")
    public Result<String> updateUserIntegral(@RequestBody UserUpadteIntegralDTO userUpadteIntegralDTO) {
        log.info("小队长更新积分:{}",userUpadteIntegralDTO);
        leaderMapper.updateIntergral(userUpadteIntegralDTO);

        return Result.success("更新完成") ;
    }

    @PostMapping("/updateUserExperience")
    @ApiOperation("更新用户经验")
    public Result<String> updateUserExperience(@RequestBody UserUpadteExperienceDTO userUpadteExperienceDTO) {
        log.info("小队长更新经验:{}",userUpadteExperienceDTO);
        leaderMapper.updateExperience(userUpadteExperienceDTO);

        return Result.success("更新完成") ;
    }
}
