package com.attend.service.Impl;

import com.attend.constant.MessageConstant;
import com.attend.dto.LeaderLoginDTO;
import com.attend.entity.Leader;
import com.attend.exception.AccountNotFoundException;
import com.attend.exception.PasswordErrorException;
import com.attend.mapper.LeaderMapper;
import com.attend.service.LeaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class LeaderServiceImpl  implements LeaderService {
    @Autowired
    LeaderMapper leaderMapper;

    @Override
    public Leader login(LeaderLoginDTO leaderLoginDTO) {
        String username = leaderLoginDTO.getUsername();
        String password = leaderLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Leader leader =leaderMapper.selectByUserName(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (leader== null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        if (!password.equals(leader.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //3、返回实体对象
        return leader;
    }
}
