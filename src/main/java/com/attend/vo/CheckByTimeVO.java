package com.attend.vo;

import com.attend.entity.Check;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckByTimeVO implements Serializable {
    List<Check> checkList;
    Integer num;
}
