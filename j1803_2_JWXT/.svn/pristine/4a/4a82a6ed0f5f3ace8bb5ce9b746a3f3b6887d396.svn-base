package com.dao.system;

import java.util.List;

import com.model.system.Classes;
import com.model.system.Student;

public interface ClassesMapper {
    int deleteByPrimaryKey(String classId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(String classId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    List<Classes> queryAllClasses();
    List<Classes> queryLikeName(String str);
}