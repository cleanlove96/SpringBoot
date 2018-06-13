/**
 * 
 */
package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.RoleMapper;
import com.dao.system.RoleMenuMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Role;
import com.model.system.RoleMenu;
import com.service.system.RoleService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月29日
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	/**
	 * 获取角色分页列表
	 */
	@Override
	public PagedResult<Role> getRolesByPage(Integer pageNumber, Integer pageSize, String searchStyle, String keywords) {
		PageHelper.startPage(pageNumber, pageSize);
		List<Role> list=null;
		if(searchStyle==null){
			list=roleMapper.findRoleAll();
		}else {
			switch(searchStyle) {
			case "roleName":list=roleMapper.findRoleLByRN(keywords);break;
			case "roleDesc":list=roleMapper.findRoleLByRD(keywords);break;
			default:list=roleMapper.findRoleAll();break;
		}
		}
		
		return PageBeanUtil.toPagedResult(list);
	}
	/**
	 * 添加角色
	 */
	@Override
	public void insertRole(Role role) {
		roleMapper.insert(role);
	}
	/**
	 * 通过roleId删除角色
	 */
	@Override
	public void delRole(String roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}
	/**
	 * 通过roleId修改角色
	 */
	@Override
	public void roleUpdate(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public Role findRoleByID(String roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}
	@Override
	public void insertRoleMenu(RoleMenu roleMenu) {
		roleMenuMapper.insert(roleMenu);
	}
	/* (non-Javadoc)
	 * @see com.service.system.RoleService#findRoleMenuByRid(java.lang.String)
	 */
	@Override
	public List<RoleMenu> findRoleMenuByRid(String roleId) {
		return roleMenuMapper.findRoleMenuByRid(roleId);
	}

	@Override
	public void delRoleMenuByRid(String roleId) {
		roleMenuMapper.delRoleMenuByRid(roleId);
	}
	
	@Override
	public List<Role> selectRoleAll() {
		// TODO Auto-generated method stub
		return roleMapper.queryAllRole();
	}

}
