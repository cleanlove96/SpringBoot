package com.controller.system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.Classes;
import com.model.system.Major;
import com.model.system.Name;
import com.model.system.Student;
import com.model.system.User;
import com.service.system.ClassesService;
import com.service.system.MajorService;
import com.service.system.StudentService;

import framework.controller.BaseController;

import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * ѧ��
 * </p>
 * 
 * @Copyright (C),����Զ��
 * @author LGH
 * @Date:2018��5��16��
 */
@Controller
@RequestMapping("/studentController")
public class StudentController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2200134348470324215L;
	@Autowired
	private StudentService studentService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private ClassesService classesService;


	
	/**
	 * <p>
	 * �б�
	 * </p>
	 * 
	 * @author LGH
	 * @Date 2018��5��16��
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------��ͳ---------------------");
		ModelAndView mv = new ModelAndView();
		// ��ǰҳ��ÿҳ������
		// �������ݵ���ҳ������
		PagedResult<Name> pageResult = studentService.queryStudentAll(pageNumber, pageSize);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		mv.addObject("pageResult", pageResult);
		mv.setViewName("student/student_list");
		return mv;
	}

	/**
	 * <p>
	 * ����
	 * </p>
	 * 
	 * @author LGH
	 * @Date 2018��5��16��
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param student
	 * @return
	 */

	
	
	@RequestMapping("add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Student student,String sId) {
		// 1���ռ�����
		System.err.println("--------------------" + student);
		// 3.�������ҵ��
		// ά��
		
		student.setCreateTime(new Date());
		int n = studentService.addStudent(student);

		// 2����תҳ��
		return "redirect:/studentController/listPage.do";

	}

	/**
	 * <p>
	 * ɾ��
	 * </p>
	 * 
	 * @author LGH
	 * @Date 2018��5��16��
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Student student, String sId) {
		int m = studentService.deleteStudentBySId(sId);
		return "redirect:/studentController/listPage.do";
	}

	/**
	 * <p>
	 * �޸�
	 * </p>
	 * 
	 * @author LGH
	 * @Date 2018��5��16��
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Student student, String sId,Name name) {
		Name s = studentService.querysId(sId);
		model.addAttribute("student", s);
		List<Major> majorlist=majorService.selectAllMajor();
		model.addAttribute("majorlist", majorlist);
		List<Classes> classeslist=classesService.selectAllClasses();
		model.addAttribute("classeslist", classeslist);

		return "student/student_update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Student student, String sId) {
		// 1.�ռ�����
		System.out.println("---------------------------------" + student);
		// 3.�������ҵ��
		int mm=studentService.updateStudent(student);
		return "redirect:/studentController/listPage.do";
	}
	
	/**
	 * <p>
	 * ����ɾ��
	 * </p>
	 * 
	 * @author LGH
	 * @Date 2018��5��16��
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/deleteMany.do")
	public String deleteMany(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Student student, String[] ids) {
		if(ids==null){return "redirect:/studentController/listPage.do";}
		for (String id : ids) {
			System.out.println(id);
			int m=studentService.deleteStudentBySId(id);
		}
		return "redirect:/studentController/listPage.do";
	}
	
	
	@RequestMapping(value = "search.do", produces = "application/json;charset=utf-8")
	public ModelAndView search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,HttpSession session,HttpServletRequest request,String str) {
		ModelAndView mv = new ModelAndView();
		if(str!=null) {
			String like =request.getParameter("str");
			session.setAttribute("str", like);
		}
		String str1 = (String)session.getAttribute("str");
		// ��ǰҳ��ÿҳ������
		// �������ݵ���ҳ������
		System.out.println("str1"+str1);
		PagedResult<Name> pageResult = studentService.queryLikeName(pageNumber, pageSize,str1);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		System.out.println(pageResult+"pageResult");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("student/student_list");
		return mv;

	}
}
