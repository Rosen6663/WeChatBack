package com.attend.vo;

import com.attend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.servlet.http.PushBuilder;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllRankingVO implements Serializable {
    List<RankingUser> rankingUsers;


}
