/**
 * 
 */
package com.service.system;

import com.model.system.Admin;
import com.model.system.Student;
import com.model.system.Teacher;
import com.model.system.User;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月30日
 */
public interface PersonService {

	/**
	 * 通过userId查找教师信息
	 * @param userId
	 * @return
	 */
	Teacher findTeacherByID(String userId);

	/**
	 * 通过userId查找学生信息
	 * @param userId
	 * @return
	 */
	Student findStudentByID(String userId);

	/**
	 * 通过userId查找管理员信息
	 * @param userId
	 * @return
	 */
	Admin findAdminByID(String userId);

	/**
	 * 通过userId查找用户信息
	 * @param userId
	 * @return
	 */
	User findUserByID(String userId);

	/**
	 * 通过userId修改用户信息
	 * @param u
	 */
	void updateUser(User u);

	/**
	 * 修改学生信息
	 * @param student
	 */
	void updateStuByID(Student student);

	/**
	 * 修改教师信息
	 * @param teacher
	 */
	void updateTeaByID(Teacher teacher);

	/**
	 * 修改管理员信息
	 * @param admin
	 */
	void updateAdmByID(Admin admin);

}
