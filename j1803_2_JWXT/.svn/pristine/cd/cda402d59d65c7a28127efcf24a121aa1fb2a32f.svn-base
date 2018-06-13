package com.controller.system;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.Teacher;
import com.model.system.User;
import com.service.system.TeacherService;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * ��ʦ
 * </p>
 * 
 * @Copyright (C),����Զ��
 * @author LGH
 * @Date:2018��5��16��
 */
@Controller
@RequestMapping("/teacherController")
public class TeacherController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5934767057032679692L;
	@Autowired
	private TeacherService teacherService;

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
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------��ͳ---------------------");
		ModelAndView mv = new ModelAndView();
		// ��ǰҳ��ÿҳ������
		// �������ݵ���ҳ������
		PagedResult<Teacher> pageResult = teacherService.getAllByPage(pageNumber, pageSize);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		mv.addObject("pageResult", pageResult);
		mv.setViewName("teacher/teacher_list");
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
	 * @param teacher
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Teacher teacher,String tId) {
		// 1���ռ�����
		System.err.println("--------------------" + teacher);
		// 3.�������ҵ��
		// ά��
		
		teacher.setCreateTime(new Date());
		int n = teacherService.addTeacher(teacher);

		// 2����תҳ��
		return "redirect:/teacherController/listPage.do";

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
	 * @param teacher
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Teacher teacher, String tId) {
		int m = teacherService.deleteTeacherById(tId);
		return "redirect:/teacherController/listPage.do";
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
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Teacher teacher, String tId) {
		Teacher t = teacherService.querytId(tId);
		model.addAttribute("teacher", t);
		return "teacher/teacher_update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Teacher teacher,String tId) {
		int mm=teacherService.updateTeacher(teacher);
		return "redirect:/teacherController/listPage.do";
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
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "/deleteMany.do")
	public String deleteMany(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Teacher teacher,String[] ids) {
		if(ids==null){return "redirect:/teacherController/listPage.do";}
		for (String id : ids) {
			System.out.println(id);
			int m=teacherService.deleteTeacherById(id);
		}
		return "redirect:/teacherController/listPage.do";
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
		PagedResult<Teacher> pageResult = teacherService.queryLikeName(pageNumber, pageSize,str1);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		System.out.println(pageResult+"pageResult");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("teacher/teacher_list");
		return mv;

	}

}
