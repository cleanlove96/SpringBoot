/**
 * 
 */
package com.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.AdminMapper;
import com.dao.system.StudentMapper;
import com.dao.system.TeacherMapper;
import com.dao.system.UserMapper;
import com.model.system.Admin;
import com.model.system.Student;
import com.model.system.Teacher;
import com.model.system.User;
import com.service.system.PersonService;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月30日
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserMapper userMapper;
	/**
	 * 通过userId查找教师信息
	 * @param userId
	 * @return
	 */
	@Override
	public Teacher findTeacherByID(String userId) {
		return teacherMapper.selectByPrimaryKey(userId);
	}
	/**
	 * 通过userId查找学生信息
	 * @param userId
	 * @return
	 */
	@Override
	public Student findStudentByID(String userId) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(userId);
	}
	/**
	 * 通过userId查找管理员信息
	 * @param userId
	 * @return
	 */
	@Override
	public Admin findAdminByID(String userId) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(userId);
	}
	
	@Override
	public User findUserByID(String userId) {
		
		return userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public void updateUser(User u) {
		userMapper.updateByPrimaryKey(u);
	}
	
	@Override
	public void updateStuByID(Student student) {
		studentMapper.updateByPrimaryKey(student);
		
	}

	@Override
	public void updateTeaByID(Teacher teacher) {
		teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public void updateAdmByID(Admin admin) {
		adminMapper.updateByPrimaryKey(admin);
	}

}
