/*****************************************************
 *  HISTORY
 *  FileName:UserServiceimp.java
 *  Package:com.service.system.impl
 *  Project:j1803_2_JWXT
 *  Version:1.0
 *  Date:2018年5月29日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.UserMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Name;
import com.model.system.User;
import com.service.system.UserService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * 
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByLoginAmeAndPassword(User user) {
		User uu = userMapper.queryUserByLoginAmeAndPassword(user);
		return uu;
	}

	@Override
	public PagedResult<User> getAllByPage(Integer pageNumber, Integer pageSize) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<User> userlist = userMapper.queryAllUser();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	@Override
	public int deleteUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public PagedResult<Name> queryLikeName(Integer pageNumber, Integer pageSize, String str1) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Name> namelist = userMapper.queryLikeName(str1);
		System.out.println(namelist + "namelist");
		return PageBeanUtil.toPagedResult(namelist);
	}

	@Override
	public PagedResult<Name> queryUserAll(Integer pageNumber, Integer pageSize) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Name> namelist = userMapper.queryUserAll();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(namelist);
	}
}
