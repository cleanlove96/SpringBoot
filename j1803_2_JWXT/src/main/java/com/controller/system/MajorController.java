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

import com.model.system.Major;

import com.service.system.MajorService;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * רҵ
 * </p>
 * 
 * @Copyright (C),����Զ��
 * @author LGH
 * @Date:2018��5��16��
 */
@Controller
@RequestMapping("/majorController")
public class MajorController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8930106666705253358L;
	@Autowired
	private MajorService majorService;

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
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------��ͳ---------------------");
		ModelAndView mv = new ModelAndView();
		// ��ǰҳ��ÿҳ������
		// �������ݵ���ҳ������
		PagedResult<Major> pageResult = majorService.getAllByPage(pageNumber, pageSize);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		mv.addObject("pageResult", pageResult);
		mv.setViewName("major/major_list");
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
	 * @param major
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Major major) {
		// 1���ռ�����
		System.err.println("--------------------" + major);
		// 3.�������ҵ��
		// ά��
		major.setMajorId(PrimaryKeyUtil.getPrimaryKey());
		major.setCreateTime(new Date());
		int n = majorService.addMajor(major);

		// 2����תҳ��
		return "redirect:/majorController/listPage.do";
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
	 * @param major
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Major major,String majorId) {
		int m=majorService.deleteMajorById(majorId);
		return "redirect:/majorController/listPage.do";
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
			Major major,String majorId) {
		Major m=majorService.querymajorId(majorId);
		model.addAttribute("major", m);
		return "major/major_update";
	}
	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Major major,String majorId) {
		int mm=majorService.updateMajor(major);
		return "redirect:/majorController/listPage.do";
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
			Major major,String[] ids) {
		if(ids==null){return "redirect:/majorController/listPage.do";}
		for (String id : ids) {
			System.out.println(id);
			int m=majorService.deleteMajorById(id);
		}
		return "redirect:/majorController/listPage.do";
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
		// 当前页和每页的条数
		// 传入数据到分页工具类
		System.out.println("str1"+str1);
		PagedResult<Major> pageResult = majorService.queryLikeName(pageNumber, pageSize,str1);
		// 数据传递到前台页面展示层
		System.out.println(pageResult+"pageResult");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("major/major_list");
		return mv;

	}
}
