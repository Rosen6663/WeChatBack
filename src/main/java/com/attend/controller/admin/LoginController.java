package com.attend.controller.admin;

import com.attend.constant.JwtClaimsConstant;
import com.attend.dto.leader.LeaderLoginDTO;
import com.attend.entity.Admin;
import com.attend.properties.JwtProperties;
import com.attend.result.Result;
import com.attend.service.LeaderService;
import com.attend.utils.JwtUtil;
import com.attend.vo.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController("AdminLoginController")
@RequestMapping("/api/admin/admin")
@Slf4j
@CrossOrigin
@Api(tags = "小队长相关接口")
public class LoginController {
    @Autowired
    LeaderService leaderService;
    @Autowired
    JwtProperties jwtProperties;
    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<AdminLoginVO> login(@RequestBody LeaderLoginDTO leaderLoginDTO) {
        log.info("用户登录：{}",leaderLoginDTO);

        Admin admin = leaderService.login(leaderLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, admin.getId());
        val token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .name(admin.getName())
                .token(token)
                .roleId(admin.getRoleId())
                .build();

        return Result.success(adminLoginVO);


    }
}
