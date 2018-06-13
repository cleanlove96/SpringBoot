package com.dao.system;

import java.util.List;

import com.model.system.Admin;
import com.model.system.Student;

public interface AdminMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    List<Admin> queryAllUser();
    List<Admin> queryLikeName(String str);
}