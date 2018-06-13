/*****************************************************
 *  HISTORY
 *  FileName:StudentService.java
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

import com.model.system.Name;
import com.model.system.Student;

import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * 
 * </p>	
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
public interface StudentService {

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 * @return
	 */
	List<Student> selectAllStudent();

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 * @param studentName
	 * @return
	 */
	Student selectStudentByName(String studentName);

	PagedResult<Student> getAllByPage(Integer pageNumber, Integer pageSize);

	int addStudent(Student student);

	int deleteStudentBySId(String sId);

	Name querysId(String sId);

	int updateStudent(Student student);

	PagedResult<Name> queryLikeName(Integer pageNumber, Integer pageSize, String str1);

	PagedResult<Name> queryStudentAll(Integer pageNumber, Integer pageSize);
}
