package com.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.system.Course;
import com.model.system.Role;
import com.model.system.ScheduleResult;
import com.model.system.Student;
import com.model.system.User;
import com.service.system.ChooseService;
import com.service.system.PersonService;
import com.service.system.RoleService;

/**
 * @Author QinPeng
 *
 * @Date 2018年6月6日
 */
@Controller
@RequestMapping("/indexController")
public class IndexController {
	@Autowired
	private PersonService personService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ChooseService chooseService;
	
	@RequestMapping("/person.do")
	public String person(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		if(user ==null) {
			return "login2";
		}
		Student student=personService.findStudentByID(user.getUserId());
		model.addAttribute("student", student);
		Role role=roleService.findRoleByID(user.getRoleId());
		model.addAttribute("role", role);
		return "person";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session,Model model) {
		session.setAttribute("user",null);
		return "login2";
	}
	@RequestMapping("/pwdUpdateUI.do")
	public String pwdUpdateUI(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		if(user ==null) {
			return "login2";
		}
		return "update_pwd";
	}
	@RequestMapping("/pwdUpdate.do")
	public String pwdUpdate(HttpSession session,Model model,User user,String password1) {
		System.out.println("--------------------user"+user);
		User u=personService.findUserByID(user.getUserId());
		String msg="";
		if(u.getPassword().equals(user.getPassword())) {
			u.setPassword(password1);
			personService.updateUser(u);
			session.setAttribute("user",u);
			msg="修改成功";
			model.addAttribute("msg", msg);
		}else {
			msg="密码错误";
			model.addAttribute("msg", msg);
		}
		System.out.println("-----------------sdfssdfsd------"+(User)session.getAttribute("user"));
		return "redirect:pwdUpdateUI.do";
	}
	
}

