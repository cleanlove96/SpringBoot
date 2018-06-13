/*****************************************************
 *  HISTORY
 *  FileName:SubjectService.java
 *  Package:com.service.system
 *  Project:j1803_2_JWXT
 *  Version:1.0
 *  Date:2018年5月29日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.service.system;

import java.util.List;

import com.model.system.Subject;

import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * 
 * </p>	
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
public interface SubjectService {

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 * @param subjectName
	 * @return
	 */
	Subject selectSubjectByName(String subjectName);

	
	PagedResult<Subject> getAllByPage(Integer pageNumber, Integer pageSize);

	int addSubject(Subject subject);

	int deleteSubjectById(String subjectId);

	Subject querysubjectId(String subjectId);

	int updateSubject(Subject subject);


	PagedResult<Subject> queryLikeName(Integer pageNumber, Integer pageSize, String str1);


	/**
	 * @return
	 */
	List<Subject> queryAllSubject();
}
