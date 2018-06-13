/**
 * 
 */
package com.controller.system;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.system.Admin;
import com.model.system.Role;
import com.model.system.Student;
import com.model.system.Teacher;
import com.model.system.User;
import com.service.system.PersonService;
import com.service.system.RoleService;
import com.service.system.TeacherService;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月30日
 */
@Controller
@RequestMapping("/personController")
public class PersonalController {
	@Autowired
	private PersonService personService;
	@Autowired
	private RoleService roleService;
/*	@RequestMapping("/selectPerson")
	public String selectPerson(HttpSession session) {
		User user=(User) session.getAttribute("user");
		System.err.println("----------------user:"+user);
		Role role=roleService.findRoleByID(user.getRoleId());
		String roleName=role.getRoleName();
		switch(roleName) {
			case "teacher":return "redirect:teacherPerson.do";
			case "student":return "redirect:studentPerson.do";
			case "admin":return "redirect:adminPerson.do";
		}
		return null;
	}*/
	/**
	 * 教师
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacherPerson.do")
	public String teacherPerson(HttpSession session,Model model) {
		User user=(User) session.getAttribute("USER");
		Teacher teacher=personService.findTeacherByID(user.getUserId());
		model.addAttribute("teacher", teacher);
		Role role=roleService.findRoleByID(user.getRoleId());
		model.addAttribute("role", role);
		return "personal/teacher_personal";
	}
	/**
	 * 学生中心
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/studentPerson.do")
	public String studentPerson(HttpSession session,Model model) {
		User user=(User) session.getAttribute("USER");
		Student student=personService.findStudentByID(user.getUserId());
		model.addAttribute("student", student);
		Role role=roleService.findRoleByID(user.getRoleId());
		model.addAttribute("role", role);
		return "personal/student_personal";
	}
	/**
	 * 管理员中心
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/adminPerson.do")
	public String adminPerson(HttpSession session,Model model) {
		User user=(User) session.getAttribute("USER");
		Admin admin=personService.findAdminByID(user.getUserId());
		model.addAttribute("admin", admin);
		Role role=roleService.findRoleByID(user.getRoleId());
		model.addAttribute("role", role);
		return "personal/admin_personal";
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @param model
	 * @param user
	 * @param password1
	 * @return
	 */
	@RequestMapping("/pwdUpdateUI.do")
	public String pwdUpdateUI(HttpSession session,Model model,User user,String password1) {
		return "personal/update_password";
	}
	@RequestMapping("/pwdUpdate.do")
	public String pwdUpdate(HttpSession session,Model model,User user,String password1) {
		System.out.println("--------------------user"+user);
		User u=personService.findUserByID(user.getUserId());
		String msg="";
		if(u.getPassword().equals(user.getPassword())) {
			u.setPassword(password1);
			personService.updateUser(u);
			session.setAttribute("USER",u);
			msg="修改成功";
			model.addAttribute("msg", msg);
		}else {
			msg="密码错误";
			model.addAttribute("msg", msg);
		}
		return "personal/update_password";
	}
	
	@RequestMapping("/stuUpdateUI.do")
	public String stuUpdateUI(Model model,String sId) {
		System.out.println("--------------------student"+sId);
		Student student=personService.findStudentByID(sId);
		model.addAttribute("student", student);
		Role role=roleService.findRoleByID(student.getRoleId());
		model.addAttribute("role", role);
		return "personal/update_student";
	}
	@RequestMapping("/stuUpdate.do")
	public String stuUpdate(Model model,Student student) {
		System.out.println("--------------------student"+student);
		personService.updateStuByID(student);
		model.addAttribute("student", student);
		Role role=roleService.findRoleByID(student.getRoleId());
		model.addAttribute("role", role);
		return "personal/student_personal";
	}
	
	@RequestMapping("/teaUpdateUI.do")
	public String teaUpdateUI(Model model,String tId) {
		System.out.println("--------------------teacherId"+tId);
		Teacher teacher=personService.findTeacherByID(tId);
		model.addAttribute("teacher", teacher);
		Role role=roleService.findRoleByID(teacher.getRoleId());
		model.addAttribute("role", role);
		return "personal/update_teacher";
	}
	@RequestMapping("/teaUpdate.do")
	public String teaUpdate(Model model,Teacher teacher) {
		System.out.println("--------------------teacher"+teacher);
		personService.updateTeaByID(teacher);
		model.addAttribute("teacher", teacher);
		Role role=roleService.findRoleByID(teacher.getRoleId());
		model.addAttribute("role", role);
		return "personal/teacher_personal";
	}
	@RequestMapping("/admUpdateUI.do")
	public String admUpdateUI(Model model,String  adminId) {
		System.out.println("--------------------adminId"+adminId);
		Admin admin=personService.findAdminByID(adminId);
		model.addAttribute("admin", admin);
		Role role=roleService.findRoleByID(admin.getRoleId());
		model.addAttribute("role", role);
		return "personal/update_admin";
	}
	@RequestMapping("/admUpdate.do")
	public String admUpdate(Model model,Admin admin) {
		System.out.println("--------------------admin"+admin);
		personService.updateAdmByID(admin);
		model.addAttribute("admin", admin);
		Role role=roleService.findRoleByID(admin.getRoleId());
		model.addAttribute("role", role);
		return "personal/admin_personal";
	}
}
