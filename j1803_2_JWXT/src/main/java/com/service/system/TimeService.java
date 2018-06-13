package com.service.system;

import java.util.List;

import com.model.system.Time;

import framework.utils.pageUtil.PagedResult;

public interface TimeService {

	PagedResult<Time> getAllByPage(Integer pageNumber, Integer pageSize);

	int addTime(Time time);

	int deleteTimeById(String timeId);

	Time querytimeId(String timeId);

	int updateTime(Time time);

	PagedResult<Time> queryLikeName(Integer pageNumber, Integer pageSize, String str1);

	/**
	 * @return
	 */
	List<Time> queryAllTime();

}
