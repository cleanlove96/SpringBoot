package com.dao.system;

import java.util.List;

import com.model.system.Name;
import com.model.system.Student;

public interface StudentMapper {
	int deleteByPrimaryKey(String sId);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(String sId);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);

	/**
	 * <p>
	 * 
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月29日
	 * @return
	 */
	List<Student> selectAllStudent();

	/**
	 * <p>
	 * 
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月29日
	 * @param studentName
	 * @return
	 */
	Student selectStudentByName(String studentName);

	List<Student> queryAllUser();

	List<Name> queryLikeName(String str);

	List<Name> queryStudentAll();
	Name selectByID(String sId);
}