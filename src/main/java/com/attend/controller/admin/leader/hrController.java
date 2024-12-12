package com.attend.controller.admin.leader;

import com.attend.entity.Activity;
import com.attend.mapper.ActivityMapper;
import com.attend.mapper.UserMapper;
import com.attend.result.Result;
import com.attend.vo.UserAddIntergal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("hrController")
@RequestMapping("/api/admin/hr")
@Slf4j
@Api(tags = "人力资源部门的相关接口")
//@CrossOrigin
public class hrController {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAllActivity")
    @ApiOperation("获取所有活动")
    public Result<List<Activity>> getAllAcitivity() {
        log.info("hr获取所有活动信息");
        List<Activity> activityList =activityMapper.getAllActivity();

        return Result.success(activityList) ;
    }

    @PostMapping("/addActivity")
    @ApiOperation("添加活动")
    public Result<String> addAcitivity(@RequestBody Activity activity) {
        log.info("添加活动信息:{}",activity);
        activityMapper.addActivity(activity);

        return Result.success("添加成功") ;
    }

    @GetMapping("/deleteActivity/{id}")
    @ApiOperation("删除活动")
    public Result<String> deleteAcitivity(@PathVariable Integer id) {
        log.info("删除活动id:{}",id);
        activityMapper.deleteActivity(id);
        return Result.success("删除成功") ;
    }

    @PostMapping("/updateActivity")
    @ApiOperation("添加活动")
    public Result<String> updateAcitivity(@RequestBody Activity activity) {
        log.info("修改活动信息:{}",activity);
        activityMapper.updateActivity(activity);

        return Result.success("添加成功") ;
    }

}
