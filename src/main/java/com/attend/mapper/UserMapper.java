package com.attend.mapper;


import com.attend.dto.user.UserPhoneLoginDTO;
import com.attend.dto.user.UserRegisterDTO;
import com.attend.dto.user.UserUpdateDTO;
import com.attend.dto.user.XuanxiukeCheckByDTO;
import com.attend.entity.Check;
import com.attend.entity.CheckElectives;
import com.attend.entity.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
//mysql
//@Mapper
//public interface UserMapper {
//    @Select("select * from users where openid=#{openid}")
//    User getByOpenid(String openid);
//
//    // 在 UserMapper 接口中
//    @Insert("INSERT INTO users (openid ,create_time) VALUES (#{openid}, #{createTime})")
//    void insert(User user);
//
//    @Select("select * from users where id=#{id}")
//    User getInfo(Long id);
//
//    void update(UserUpdateDTO userUpdateDTO);
//
//    @Select("select nick_name from users where id=#{id}")
//    String getById(Long id);
//
//    @Update("update users set nick_name=#{nickName},avatar=#{avatar} where id=#{id}")
//    void updateById(UserRegisterDTO userRegisterDTO);
//
//    @Select("SELECT * FROM checks WHERE user_id = #{id} AND DATE(check_in_time) = CURDATE()  ORDER BY check_in_time DESC LIMIT 1; ")
//    Check selectTodyCheck(Long id);
//    @Insert("INSERT INTO checks (check_in_time, check_in_location, round_number, user_id) VALUES ( now(), #{checkInLocation}, 1, #{userId})")
//    void chenkInInsert(Check check);
//    @Select("SELECT COUNT(*) FROM checks WHERE user_id = #{id} AND DATE(check_in_time) = CURDATE() ")
//    Integer chenkTodyCount(Long id);
//    @Insert("INSERT INTO checks (check_in_time, check_in_location, round_number, user_id) VALUES ( now(), #{checkInLocation}, #{roundNumber}, #{userId})")
//    void chenkInInsertNoNew(Check check);
//    @Update("UPDATE checks SET check_out_time = now(),check_out_location=#{check.checkOutLocation},experience=#{check.experience} WHERE user_id = #{check.userId} AND DATE(check_in_time) = CURDATE() AND id = #{id}")
//    void chenkUpdateNew(Check check,Integer id);
//
//    /**
//     * 查询最新一条签到签退信息
//     * @param id
//     * @return
//     */
//    @Select("SELECT \n" +
//            "    TIMESTAMPDIFF(MINUTE, check_in_time, check_out_time) AS time_difference_minutes,\n" +
//            "    check_in_time,\n" +
//            "    check_out_time\n" +
//            "FROM \n" +
//            "    checks\n" +
//            "WHERE \n" +
//            "    user_id = #{id}\n" +
//            "AND \n" +
//            "    DATE(check_in_time) = CURDATE()\n" +
//            "ORDER BY \n" +
//            "    check_in_time DESC\n" +
//            "LIMIT 1;")
//    Double selectTimeD(Long id);
//    @Update("UPDATE users SET experience = experience + IFNULL(#{jingyan}, 0) WHERE id = #{id}")
//    void insertJingyan(Double jingyan,Long id);
//
//    /**
//     * 查询全部打卡信息
//     * @param id
//     * @return
//     */
//    @Select("select * from checks where user_id=#{id}")
//    List<Check> getChecksById(Long id);
//
//    @Select("SELECT * FROM checks WHERE user_id=#{id} AND DATE(check_in_time) = DATE(#{selectDate})")
//    List<Check> selectCheckByTime(String id, LocalDate selectDate);
//
//    @Select("SELECT * FROM users where nick_name IS NOT NULL ORDER BY experience DESC ;")
//    List<User> selectUserRank();
//    @Update("update checks set experience=#{v} where id=#{id}")
//    void updateJingyan(double v, Integer id);
//
//}
@Mapper
public interface UserMapper {




    @Select("select * from users where openid=#{openid}")
    User getByOpenid(String openid);

    // 在 UserMapper 接口中
    @Insert("INSERT INTO users (openid ,create_time) VALUES (#{openid}, #{createTime})")
    void insert(User user);

    @Select("select * from users where id=#{id}")
    User getInfo(Long id);

    void update(UserUpdateDTO userUpdateDTO);

    @Select("select nick_name from users where id=#{id}")
    String getById(Long id);

    @Update("update users set nick_name=#{nickName},avatar=#{avatar} where id=#{id}")
    void updateById(UserRegisterDTO userRegisterDTO);

    @Select("SELECT * FROM checks WHERE user_id = #{id} AND DATE_TRUNC('day',check_in_time) = CURRENT_DATE  ORDER BY check_in_time DESC LIMIT 1; ")
    Check selectTodyCheck(Long id);
    @Insert("INSERT INTO checks (check_in_time, check_in_location, round_number, user_id) VALUES ( now(), #{checkInLocation}, 1, #{userId})")
    void chenkInInsert(Check check);
    @Select("SELECT COUNT(*) FROM checks WHERE user_id = #{id} AND DATE_TRUNC('day',check_in_time) = CURRENT_DATE ")
    Integer chenkTodyCount(Long id);
    @Insert("INSERT INTO checks (check_in_time, check_in_location, round_number, user_id) VALUES ( now(), #{checkInLocation}, #{roundNumber}, #{userId})")
    void chenkInInsertNoNew(Check check);
    @Update("UPDATE checks SET check_out_time = now(),check_out_location=#{check.checkOutLocation},experience=#{check.experience} WHERE user_id = #{check.userId} AND  DATE_TRUNC('day',check_in_time) = CURRENT_DATE AND id = #{id}")
    void chenkUpdateNew(Check check,Integer id);

    /**
     * 查询最新一条签到签退信息
     * @param id
     * @return
     */
    @Select("SELECT \n" +
            "    EXTRACT(EPOCH FROM (check_out_time - check_in_time)) / 60 AS time_difference_minutes,\n" +
            "    check_in_time,\n" +
            "    check_out_time\n" +
            "FROM \n" +
            "    checks\n" +
            "WHERE \n" +
            "    user_id = #{id}\n" +
            "AND \n" +
            "    DATE_TRUNC('day', check_in_time) = CURRENT_DATE\n" +
            "ORDER BY \n" +
            "    check_in_time DESC\n" +
            "LIMIT 1;")
    Double selectTimeD(Long id);
    @Update("UPDATE users SET experience = experience + COALESCE(#{jingyan}, 0) WHERE id = #{id}")
    void insertJingyan(Double jingyan,Long id);

    /**
     * 查询全部打卡信息
     * @param id
     * @return
     */
    @Select("select * from checks where user_id=#{id}")
    List<Check> getChecksById(Long id);

    @Select("SELECT * FROM checks WHERE user_id=#{id} AND DATE_TRUNC('day',check_in_time )= DATE_TRUNC('day',#{selectDate})")
    List<Check> selectCheckByTime(String id, LocalDate selectDate);

    @Select("SELECT * FROM users where nick_name IS NOT NULL ORDER BY experience DESC ;")
    List<User> selectUserRank();
    @Update("update checks set experience=#{v} where id=#{id}")
    void updateJingyan(double v, Integer id);
    @Insert("insert into check_electives(user_id, location, image,check_time) values (#{userId},#{location},#{image},now())")
    void insertElectivesCheck(XuanxiukeCheckByDTO xuanxiukeCheckByDTO);
    @Select("select * from check_electives where user_id=#{userId} and DATE_TRUNC('day', check_time) = CURRENT_DATE")
    CheckElectives selectElectivesCheck(Integer userId);
    @Update("update users set experience=experience+50.0 where id=#{userId}")
    void updateExperienceByElectives(Integer userId);
    @Select("select *from users where telephone=#{telephone} and password=#{password}")
    User loginOnphone(UserPhoneLoginDTO userPhoneLoginDTO);
}
