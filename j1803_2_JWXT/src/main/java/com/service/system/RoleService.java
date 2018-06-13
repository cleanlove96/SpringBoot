/**
 * 
 */
package com.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.system.Role;
import com.model.system.RoleMenu;

import framework.utils.pageUtil.PagedResult;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月29日
 */

public interface RoleService {

	/**
	 * 添加角色
	 * @param role
	 */
	void insertRole(Role role);

	/**
	 * 通过roleId删除角色
	 * @param roleId
	 */
	void delRole(String roleId);

	/**
	 * 获取角色分页列表
	 * @param pageNumber
	 * @param pageSize
	 * @param searchStyle
	 * @param keywords
	 * @return
	 */
	PagedResult<Role> getRolesByPage(Integer pageNumber, Integer pageSize, String searchStyle, String keywords);
	/**
	 * 通过roleId修改角色
	 * @param role
	 */
	void roleUpdate(Role role);

	/**
	 * 通过roleId查询角色
	 * @param roleId
	 * @return
	 */
	Role findRoleByID(String roleId);

	/**
	 * 添加角色菜单关联
	 * @param roleMenu
	 */
	void insertRoleMenu(RoleMenu roleMenu);

	/**
	 * 通过roleId查询RoleMenu
	 * @param roleId
	 * @return
	 */
	List<RoleMenu> findRoleMenuByRid(String roleId);

	/**
	 * 通过roleId删除RoleMenu
	 * @param roleId
	 */
	void delRoleMenuByRid(String roleId);
	List<Role> selectRoleAll();
}
