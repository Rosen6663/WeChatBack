package com.attend.mapper;

import com.attend.dto.leader.LeaderAddUserDTO;
import com.attend.dto.leader.LeaderDeleteUserDTO;
import com.attend.dto.leader.UserUpadteExperienceDTO;
import com.attend.dto.leader.UserUpadteIntegralDTO;
import com.attend.entity.Admin;
import com.attend.entity.LeaderUser;
import com.attend.entity.User;
import com.attend.vo.UserAddIntergal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeaderMapper {
    @Select("select * from admin where username=#{username}")
    Admin selectByUserName(String username);
    @Select("select id,nick_name,integral,experience from users where nick_name IS NOT NULL")
    List<UserAddIntergal> getAllNickName();
    @Select("select users.id,nick_name,integral,experience from users,leader_user where nick_name IS NOT NULL and  leader_user.admin_id=#{id} and user_id=users.id  ")
    List<UserAddIntergal> getLeaderNickName(Integer id);


    @Update("update users set integral=#{integral} where id=#{userId}")
    void updateIntergral(UserUpadteIntegralDTO userUpadteIntegralDTO);
    @Update("update users set experience=#{experience} where id=#{userId}")
    void updateExperience(UserUpadteExperienceDTO userUpadteExperienceDTO);
    @Insert("insert into leader_user(user_id, admin_id) VALUES (#{userId},#{adminId})")
    void leaderAddUser(LeaderAddUserDTO leaderAddUserDTO);
    @Select("select * from leader_user where admin_id=#{adminId} and user_id=#{userId}")
    LeaderUser selectByUserIdLeaderId(LeaderAddUserDTO leaderAddUserDTO);
    @Select("select * from users,leader_user where leader_user.admin_id=#{id} and leader_user.user_id=users.id")
    List<User> selectByLeaderId(Integer id);
    @Delete("delete from leader_user where user_id=#{userId} and admin_id=#{adminId}")
    void deleteUserIdLeaderId(LeaderDeleteUserDTO leaderAddUserDTO);
}
