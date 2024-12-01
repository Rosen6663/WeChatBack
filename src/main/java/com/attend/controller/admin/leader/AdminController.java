package com.attend.controller.admin.leader;

import com.attend.dto.leader.LeaderAddUserDTO;
import com.attend.dto.leader.LeaderDeleteUserDTO;
import com.attend.dto.leader.UserUpadteExperienceDTO;
import com.attend.dto.leader.UserUpadteIntegralDTO;
import com.attend.entity.LeaderUser;
import com.attend.entity.User;
import com.attend.mapper.LeaderMapper;
import com.attend.result.Result;
import com.attend.vo.UserAddIntergal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController("LeaderController")
@RequestMapping("/api/admin/leader")
@Slf4j
@Api(tags = "小队长相关接口")
@CrossOrigin
public class AdminController {

    @Autowired
    private LeaderMapper leaderMapper;


    @GetMapping("/getAllNickName")
    @ApiOperation("查询所有新生姓名")
    public Result<List<UserAddIntergal>> getAllUserNickName(Integer id,String name) {
        log.info("小队长:{},{}进行查询",name,id);
        List<UserAddIntergal> userAddIntergals= leaderMapper.getAllNickName();

        return Result.success(userAddIntergals) ;
    }

    @GetMapping("/getLeaderUserNickName/{id}")
    @ApiOperation("查询所有新生姓名")
    public Result<List<UserAddIntergal>> getLeaderUserNickName(@PathVariable Integer id) {
        log.info("小队长:{}进行查询",id);
        List<UserAddIntergal> userAddIntergals= leaderMapper.getLeaderNickName(id);

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

    /**
     * leader
     */
    @PostMapping("/leaderAddUser")
    @ApiOperation("小队长添加队员接口")
    public Result<String> leaderAddUser(@RequestBody LeaderAddUserDTO leaderAddUserDTO) {
        log.info("小队长添加队员:{}",leaderAddUserDTO);
        LeaderUser leaderUser=leaderMapper.selectByUserIdLeaderId(leaderAddUserDTO);
        if(leaderUser!=null){
            return Result.error("不能重复添加哦");
        }
        leaderMapper.leaderAddUser(leaderAddUserDTO);
        return Result.success("添加完成") ;
    }

    @GetMapping("/getLeaderOfUser/{id}")
    @ApiOperation("小队长查询队员接口")
    public Result<List<User>> getLeaderOfUser(@PathVariable Integer id) {
        log.info("小队长添加队员:{}",id);
        List<User> users=leaderMapper.selectByLeaderId(id);
        return Result.success(users);
    }

    @PostMapping("/deleteUserLeader")
    @ApiOperation("小队长查询队员接口")
    public Result<String> getLeaderOfUser(@RequestBody LeaderDeleteUserDTO leaderDeleteUserDTO) {
        log.info("小队长删除队员:{}",leaderDeleteUserDTO);
        leaderMapper.deleteUserIdLeaderId(leaderDeleteUserDTO);
        return Result.success("删除成功");
    }


}
