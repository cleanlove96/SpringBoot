/*****************************************************
 *  HISTORY
 *  FileName:ScoreServiceimp.java
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

import com.dao.system.ScoreMapper;
import com.dao.system.UserMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.NewScore;
import com.model.system.Score;
import com.service.system.ScoreService;

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
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public int insertScore(Score score) {

		return scoreMapper.insert(score);
	}

	@Override
	public List<NewScore> selectAllScore() {

		return scoreMapper.queryAllScore();
	}

	@Override
	public List<NewScore> selectAllStudScore(String userId) {

		return scoreMapper.selectAllStudScore(userId);
	}

	@Override
	public List<NewScore> selectStudScoreById(String userId) {

		return scoreMapper.selectStudScoreById(userId);
	}

	@Override
	public NewScore querySelectById(String tId, String sId, String subjectId) {

		return scoreMapper.querySelectById(tId, sId, subjectId);
	}

	@Override
	public int updatescore(String scoreId, String score) {

		return scoreMapper.updatescore(scoreId, score);
	}

	@Override
	public List<NewScore> selectAllbyUserId(String userId) {

		return scoreMapper.selectAllbyUserId(userId);
	}

	@Override
	public NewScore queryselectByScoreId(String scoreId) {

		return scoreMapper.queryselectByScoreId(scoreId);
	}

	@Override
	public int selectBySidTidSubjectid(String studentId, String teacherId, String subjectId) {

		return scoreMapper.selectBySidTidSubjectid(studentId, teacherId, subjectId);
	}

	@Override
	public PagedResult<NewScore> teacherSelectStudByTid(Integer pageNumber, Integer pageSize, String userId) {

		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.selectAllStudScore(userId);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);

	}

	@Override
	public PagedResult<NewScore> StudselectScoreById(Integer pageNumber, Integer pageSize, String userId) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.selectStudScoreById(userId);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> selectAllScorebyUserId(Integer pageNumber, Integer pageSize, String userId) {

		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.selectAllbyUserId(userId);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	/***
	 * 根据老师Id和学生姓名进行准确查询
	 */
	// @Override
	// public List<NewScore> selectStudentByName(String userId, String str) {
	//
	// return scoreMapper.selectStudentByName(userId,str);
	// }

	@Override
	public PagedResult<NewScore> selectStudentByName(Integer pageNumber, Integer pageSize, String userId, String str) {

		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.selectStudentByName(userId, str);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> studentselectBysbujectName(Integer pageNumber, Integer pageSize, String userId,
			String str) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.studentselectBysbujectName(userId, str);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> adminselectAllScore(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.adminselectAllScore();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> adminselectStudentScore(Integer pageNumber, Integer pageSize, String namestr) {

		List<NewScore> userlist = scoreMapper.adminselectStudentScore(namestr);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> adminselectSubjectScore(Integer pageNumber, Integer pageSize, String subjectstr) {
		List<NewScore> userlist = scoreMapper.adminselectSubjectScore(subjectstr);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> querySelectStudent(Integer pageNumber, Integer pageSize, String userId) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.selectAllStudScore(userId);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);

	}

	@Override
	public PagedResult<NewScore> querySelectSubjectStudent(Integer pageNumber, Integer pageSize, String userId) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.selectStudScoreById(userId);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> queryAdminStudent(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.adminselectAllScore();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> queryAdminSubjectScore(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.adminselectAllScore();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> StudselectScoreByIdgropu(Integer pageNumber, Integer pageSize, String userId) {
		// 1.调用分页插件
				PageHelper.startPage(pageNumber, pageSize);
				// 2.查询数据库，获取数据
				List<NewScore> userlist = scoreMapper.selectStudScoreByIdgroup(userId);
				// 3.通过分页工具类加载分页数据
				return PageBeanUtil.toPagedResult(userlist);
	}

	@Override
	public PagedResult<NewScore> adminselectAllScoreGroup(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<NewScore> userlist = scoreMapper.adminselectAllScoreGroup();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(userlist);
	}
}
