package com.attend.mapper;

import com.attend.dto.leader.LeaderAddUserDTO;
import com.attend.dto.leader.LeaderDeleteUserDTO;
import com.attend.dto.leader.UserUpadteExperienceDTO;
import com.attend.dto.leader.UserUpadteIntegralDTO;
import com.attend.entity.Activity;
import com.attend.entity.Admin;
import com.attend.entity.LeaderUser;
import com.attend.entity.User;
import com.attend.vo.UserAddIntergal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActivityMapper {
    @Select("select * from activities")
    List<Activity> getAllActivity();
    @Insert("insert into activities(name, format, location, type, max_participants, description, task, start_time, end_time, deadline, status,exp_reward,point_reward,min_level) values(#{name}, #{format}, #{location}, #{type}, #{maxParticipants}, #{description}, #{task}, #{startTime}, #{endTime}, #{deadline}, #{status},#{expReward},#{pointReward},#{minLevel})")
    void addActivity(Activity activity);
    @Delete("delete from activities where id=#{id}")
    void deleteActivity(Integer id);
    @Update("update activities set name=#{name},format=#{format},location=#{location},type=#{type},max_participants=#{maxParticipants},description=#{description},task=#{task},start_time=#{startTime},end_time=#{endTime},deadline=#{deadline},status=#{status},exp_reward=#{expReward},point_reward=#{pointReward},min_level=#{minLevel} where id=#{id}")
    void updateActivity(Activity activity);
}
