package com.attend.service;

import com.attend.dto.leader.LeaderLoginDTO;
import com.attend.entity.Admin;

public interface LeaderService {
    Admin login(LeaderLoginDTO loginDTO);
}
