package com.attend.mapper;

import com.attend.dto.UserUpadteExperienceDTO;
import com.attend.dto.UserUpadteIntegralDTO;
import com.attend.entity.Leader;
import com.attend.vo.UserAddIntergal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LeaderMapper {
    @Select("select * from leader where username=#{username}")
    Leader selectByUserName(String username);
    @Select("select id,nick_name,integral,experience from users where nick_name IS NOT NULL")
    List<UserAddIntergal> getAllNickName();
    @Update("update users set integral=#{integral} where id=#{userId}")
    void updateIntergral(UserUpadteIntegralDTO userUpadteIntegralDTO);
    @Update("update users set experience=#{experience} where id=#{userId}")
    void updateExperience(UserUpadteExperienceDTO userUpadteExperienceDTO);
}
