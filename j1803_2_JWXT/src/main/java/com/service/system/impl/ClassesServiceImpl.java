package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.ClassesMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Classes;
import com.service.system.ClassesService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

@Service
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public PagedResult<Classes> getAllByPage(Integer pageNumber, Integer pageSize) {
		// 1.���÷�ҳ���
		PageHelper.startPage(pageNumber, pageSize);
		// 2.��ѯ���ݿ⣬��ȡ����
		List<Classes> classeslist = classesMapper.queryAllClasses();
		// 3.ͨ����ҳ��������ط�ҳ����
		return PageBeanUtil.toPagedResult(classeslist);
	}

	@Override
	public int addClasses(Classes classes) {
		// TODO Auto-generated method stub
		return classesMapper.insertSelective(classes);
	}

	@Override
	public int deleteClassesById(String classId) {
		// TODO Auto-generated method stub
		return classesMapper.deleteByPrimaryKey(classId);
	}

	@Override
	public Classes queryclassesId(String classId) {
		// TODO Auto-generated method stub
		return classesMapper.selectByPrimaryKey(classId);
	}

	@Override
	public int updateClasses(Classes classes) {
		// TODO Auto-generated method stub
		return classesMapper.updateByPrimaryKeySelective(classes);
	}

	@Override
	public List<Classes> selectAllClasses() {
		// TODO Auto-generated method stub
		return classesMapper.queryAllClasses();
	}

	@Override
	public PagedResult<Classes> queryLikeName(Integer pageNumber, Integer pageSize, String str1) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Classes> classeslist = classesMapper.queryLikeName(str1);
		System.out.println(classeslist + "classeslist");
		return PageBeanUtil.toPagedResult(classeslist);
	}

}
