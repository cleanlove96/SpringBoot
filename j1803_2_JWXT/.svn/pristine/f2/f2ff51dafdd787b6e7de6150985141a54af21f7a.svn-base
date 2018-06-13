package com.service.system;

import java.util.List;

import com.model.system.Classes;

import framework.utils.pageUtil.PagedResult;

public interface ClassesService {

	PagedResult<Classes> getAllByPage(Integer pageNumber, Integer pageSize);

	int addClasses(Classes classes);

	int deleteClassesById(String classId);

	Classes queryclassesId(String classId);

	int updateClasses(Classes classes);

	List<Classes> selectAllClasses();

	PagedResult<Classes> queryLikeName(Integer pageNumber, Integer pageSize, String str1);

}
