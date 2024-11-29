package com.attend.service;

import com.attend.dto.LeaderLoginDTO;
import com.attend.entity.Leader;

public interface LeaderService {
    Leader login(LeaderLoginDTO loginDTO);
}
