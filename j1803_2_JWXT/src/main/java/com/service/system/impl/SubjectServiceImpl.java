/*****************************************************
 *  HISTORY
 *  FileName:SubjectServiceimp.java
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

import com.dao.system.SubjectMapper;
import com.dao.system.UserMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Subject;
import com.service.system.SubjectService;

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
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectMapper subjectMapper;

	@Override
	public Subject selectSubjectByName(String subjectName) {

		return subjectMapper.selectSubjectByName(subjectName);
	}

	@Override
	public PagedResult<Subject> getAllByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<Subject> subjectlist = subjectMapper.queryAllSubject();
		return PageBeanUtil.toPagedResult(subjectlist);
	}

	@Override
	public int addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectMapper.insertSelective(subject);
	}

	@Override
	public int deleteSubjectById(String subjectId) {
		// TODO Auto-generated method stub
		return subjectMapper.deleteByPrimaryKey(subjectId);
	}

	@Override
	public Subject querysubjectId(String subjectId) {
		// TODO Auto-generated method stub
		return subjectMapper.selectByPrimaryKey(subjectId);
	}

	@Override
	public int updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectMapper.updateByPrimaryKeySelective(subject);
	}
	@Override
	public List<Subject> queryAllSubject() {
		return subjectMapper.queryAllSubject();
	}

	@Override
	public PagedResult<Subject> queryLikeName(Integer pageNumber, Integer pageSize, String str1) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Subject> subjectlist = subjectMapper.queryLikeName(str1);
		System.out.println(subjectlist + "subjectlist");
		return PageBeanUtil.toPagedResult(subjectlist);
	}

}
