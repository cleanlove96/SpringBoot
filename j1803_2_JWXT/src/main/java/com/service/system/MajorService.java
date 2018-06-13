package com.service.system;

import java.util.List;

import com.model.system.Major;

import framework.utils.pageUtil.PagedResult;

public interface MajorService {

	PagedResult<Major> getAllByPage(Integer pageNumber, Integer pageSize);

	int addMajor(Major major);

	int deleteMajorById(String majorId);

	Major querymajorId(String majorId);

	int updateMajor(Major major);

	List<Major> selectAllMajor();

	PagedResult<Major> queryLikeName(Integer pageNumber, Integer pageSize, String str1);

}
