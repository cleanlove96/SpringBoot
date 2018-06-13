package com.service.system;

import com.model.system.Admin;

import framework.utils.pageUtil.PagedResult;

public interface AdminService {

	PagedResult<Admin> getAllByPage(Integer pageNumber, Integer pageSize);

	int addAdmin(Admin admin);

	int deleteAdminByAdminId(String adminId);

	Admin queryadminId(String adminId);

	int updateAdmin(Admin admin);

	PagedResult<Admin> queryLikeName(Integer pageNumber, Integer pageSize, String str1);

}
