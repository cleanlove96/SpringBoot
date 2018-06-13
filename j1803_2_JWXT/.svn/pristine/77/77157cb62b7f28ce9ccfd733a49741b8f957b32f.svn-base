/*****************************************************
 *  HISTORY
 *  FileName:TeacherService.java
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

import com.model.system.SubjectTeacherStudent;
import com.model.system.Teacher;

import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * 
 * </p>	
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
public interface TeacherService {

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 */
	List<Teacher> selectAllTeacher();

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 * @param userId
	 * @return
	 */
	List<SubjectTeacherStudent> selectsubByTeacherId(String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param sId
	 * @param userId 
	 * @param name 
	 * @return
	 */
	SubjectTeacherStudent selectsubBySutId(String sId, String userId, String name);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<SubjectTeacherStudent> selectsubByTeacherByPage(Integer pageNumber, Integer pageSize, String userId);

	
	PagedResult<Teacher> getAllByPage(Integer pageNumber, Integer pageSize);

	int addTeacher(Teacher teacher);

	int deleteTeacherById(String tId);

	Teacher querytId(String tId);

	int updateTeacher(Teacher teacher);

	PagedResult<Teacher> queryLikeName(Integer pageNumber, Integer pageSize, String str1);


	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param pageSize
	 * @param sName
	 * @param userId
	 * @return
	 */
	PagedResult<SubjectTeacherStudent> queryStudentAndTeacher(Integer pageNumber, Integer pageSize, String sName,
			String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<SubjectTeacherStudent> selectsubByTeacherByPageGroup(Integer pageNumber, Integer pageSize,
			String userId);


	List<Teacher> queryAllTeacher();

}
