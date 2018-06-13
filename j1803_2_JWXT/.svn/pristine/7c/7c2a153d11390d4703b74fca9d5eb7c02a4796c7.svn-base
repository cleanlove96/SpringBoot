package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Admin;
import com.service.system.AdminService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public PagedResult<Admin> getAllByPage(Integer pageNumber, Integer pageSize) {
		// 1.���÷�ҳ���
		PageHelper.startPage(pageNumber, pageSize);
		// 2.��ѯ���ݿ⣬��ȡ����
		List<Admin> adminlist = adminMapper.queryAllUser();
		// 3.ͨ����ҳ��������ط�ҳ����
		return PageBeanUtil.toPagedResult(adminlist);
	}

	@Override
	public int addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.insertSelective(admin);
	}

	@Override
	public int deleteAdminByAdminId(String adminId) {
		// TODO Auto-generated method stub
		return adminMapper.deleteByPrimaryKey(adminId);
	}

	@Override
	public Admin queryadminId(String adminId) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(adminId);
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public PagedResult<Admin> queryLikeName(Integer pageNumber, Integer pageSize, String str1) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Admin> adminlist = adminMapper.queryLikeName(str1);
		System.out.println(adminlist + "adminlist");
		return PageBeanUtil.toPagedResult(adminlist);
	}

}
