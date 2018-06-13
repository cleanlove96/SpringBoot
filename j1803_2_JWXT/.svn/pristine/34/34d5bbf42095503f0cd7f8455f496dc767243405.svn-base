package com.dao.system;

import java.util.List;

import com.model.system.Major;
import com.model.system.Student;

public interface MajorMapper {
    int deleteByPrimaryKey(String majorId);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(String majorId);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
    List<Major> queryAllMajor();
    List<Major> queryLikeName(String str);
}