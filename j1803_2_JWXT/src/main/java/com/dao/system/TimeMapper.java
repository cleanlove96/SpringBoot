package com.dao.system;

import java.util.List;

import com.model.system.Student;
import com.model.system.Time;

public interface TimeMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(Time record);

    int insertSelective(Time record);

    Time selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
    List<Time> queryAllTime();
    List<Time> queryLikeName(String str);
}