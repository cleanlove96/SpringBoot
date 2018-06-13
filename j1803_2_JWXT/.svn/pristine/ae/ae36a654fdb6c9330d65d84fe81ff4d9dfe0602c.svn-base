package com.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.Time;
import com.service.system.TimeService;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * �Ͽ�ʱ��
 * </p>
 * 
 * @Copyright (C),����Զ��
 * @author LGH
 * @Date:2018��5��16��
 */
@Controller
@RequestMapping("/timeController")
public class TimeController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6740082744786491759L;

	@Autowired
	private TimeService timeService;

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
	 * @param time
	 * @return
	 */
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------��ͳ---------------------");
		ModelAndView mv = new ModelAndView();
		// ��ǰҳ��ÿҳ������
		// �������ݵ���ҳ������
		PagedResult<Time> pageResult = timeService.getAllByPage(pageNumber, pageSize);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		mv.addObject("pageResult", pageResult);
		mv.setViewName("time/time_list");
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
	 * @param time
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Time time){
		time.setTimeId(PrimaryKeyUtil.getPrimaryKey());
		int n=timeService.addTime(time);
		return "redirect:/timeController/listPage.do";
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
	 * @param time
	 * @param String
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Time time,String timeId){
		int m=timeService.deleteTimeById(timeId);
		return "redirect:/timeController/listPage.do";
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
	 * @param time
	 * @param String
	 * @return
	 */
	@RequestMapping("updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Time time,String timeId){
		Time ti=timeService.querytimeId(timeId);
		model.addAttribute("time", ti);
		return "time/time_update";
		
	}
	@RequestMapping("update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Time time,String timeId){
		int mm=timeService.updateTime(time);
		return "redirect:/timeController/listPage.do";
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
	 * @param time
	 * @param String
	 * @return
	 */
	@RequestMapping(value = "/deleteMany.do")
	public String deleteMany(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Time time,String[] ids){
		if(ids==null){return "redirect:/timeController/listPage.do";}
		for (String id : ids) {
			int m=timeService.deleteTimeById(id);
		}
		return "redirect:/timeController/listPage.do";
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
		PagedResult<Time> pageResult = timeService.queryLikeName(pageNumber, pageSize,str1);
		// 数据传递到前台页面展示层
		System.out.println(pageResult+"pageResult");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("time/time_list");
		return mv;

	}

}
