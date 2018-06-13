package com.dao.system;

import java.util.List;

import com.model.system.RoleMenu;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(String roleMenuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(String roleMenuId);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

	/**
	 * 通过roleId查询
	 * @param roleId
	 * @return
	 */
	List<RoleMenu> findRoleMenuByRid(String roleId);

	/**
	 * 通过roleId删除
	 * @param roleId
	 */
	void delRoleMenuByRid(String roleId);
}