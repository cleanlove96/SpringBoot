/*****************************************************
 *  HISTORY
 *  FileName:ScoreController.java
 *  Package:com.controller.system
 *  Project:j1803_2_JWXT
 *  Version:1.0
 *  Date:2018年5月29日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.controller.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.NewScore;
import com.model.system.Score;
import com.model.system.Student;
import com.model.system.Subject;
import com.model.system.SubjectTeacherStudent;
import com.model.system.Teacher;
import com.model.system.User;
import com.service.system.ScoreService;
import com.service.system.StudentService;
import com.service.system.SubjectService;
import com.service.system.TeacherService;
import com.service.system.UserService;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * 
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
@Controller
@RequestMapping("/scoreController")
public class ScoreController extends BaseController {

	/**  */
	private static final long serialVersionUID = 5100291237447060883L;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SubjectService subjectService;

	/***
	 * 
	 * <p>
	 * 查询出当前教师所上课的学生 并返回一个新的model的结果集，并返回到前台table中
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/Scoreregistration.do")
	public String Score_registration(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user) {
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		System.out.println("当前教师id" + userId);
		List<SubjectTeacherStudent> sub = teacherService.selectsubByTeacherId(userId);
		System.out.println(sub.toString());
		model.addAttribute("sub", sub);
		return "Score/Scoreregistration";

	}

	/***
	 * 
	 * <p>
	 * 分页显示
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月31日
	 */
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, HttpSession session) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		PagedResult<SubjectTeacherStudent> pageResult = teacherService.selectsubByTeacherByPage(pageNumber, pageSize,
				userId);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/Scoreregistration");
		return mv;

	}
	/***
	 * 
	 * <p>
	 * 分数录入界面的精确查询学生
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @param sName
	 * @return
	 */
	@RequestMapping(value = "teacherselectStudentScore.do", produces = "application/json;charset=utf-8")
	public ModelAndView teacherselectStudentScore(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, HttpSession session,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, String sName) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		if (sName.equals("")) {
			PagedResult<SubjectTeacherStudent> pageResult = teacherService.selectsubByTeacherByPage(pageNumber, pageSize,
					userId);
			// 数据传递到前台页面展示层
			System.out.println("当前教师id"+userId);
			System.out.println("输入的学生名字"+sName);
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/Scoreregistration");
			return mv;
		} else {
			PagedResult<SubjectTeacherStudent> pageResult = teacherService.queryStudentAndTeacher(pageNumber, pageSize, sName,userId);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/Scoreregistration");
			return mv;
		}

	}
	/***
	 * 
	 * <p>
	 * 老师查询学生成绩进行排序
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @param sName
	 * @return
	 */
	@RequestMapping(value = "teacherselectStudentScoreGroup.do", produces = "application/json;charset=utf-8")
	public ModelAndView teacherselectStudentScoreGroup(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, HttpSession session,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		// 当前页和每页的条数
		// 传入数据到分页工具类		
			PagedResult<SubjectTeacherStudent> pageResult = teacherService.selectsubByTeacherByPageGroup(pageNumber, pageSize,
					userId);
			// 数据传递到前台页面展示层
			System.out.println("当前教师id"+userId);		
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/Scoreregistration");
			return mv;		
	}

	/***
	 * 
	 * <p>
	 * 学生成绩表的一个回显，显示教师科目学生名字 成绩等等，并返回到前台
	 *
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @param sId
	 * @return
	 */
	@RequestMapping("/ScoreSuccess.do")
	public void ScoreSuccess(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user, String sId,String name) {
		User u = (User) session.getAttribute("USER");
		System.out.println("科目id"+name);
		String userId = u.getUserId();
		System.out.println("当前教师id  是是是 " + userId);
		System.out.println("当前学生id  sss " + sId);
		SubjectTeacherStudent sub1 = teacherService.selectsubBySutId(sId, userId,name);
		System.out.println(sub1.toString());
		String studentId = sub1.getsId();
		String subjectId = sub1.getSubjectId();
		String teacherId = sub1.gettId();
		int score2 = scoreService.selectBySidTidSubjectid(studentId, teacherId, subjectId);
		System.out.println("查询结果为：" + score2);
		if (score2 == 0) {
			
		} else {

			try {
				ServletOutputStream servletOutputStream = response.getOutputStream();
				servletOutputStream.print("111");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	/***
	 * 
	 * <p>
	 * 用于录入分数的回显示
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年6月4日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @param sId
	 */
	@RequestMapping("/ScoreSuccessUI.do")
	public String ScoreSuccessUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user, String sId,String name) {
		User u = (User) session.getAttribute("USER");	
		String userId = u.getUserId();
		System.out.println("科目id"+name);
		System.out.println("当前教师id  " + userId);
		System.out.println("当前学生id  " + sId);
		SubjectTeacherStudent sub1 = teacherService.selectsubBySutId(sId, userId,name);
		//System.out.println(sub1.toString());				
		model.addAttribute("sub1", sub1);
		return "Score/inputScore";
	}

	/***
	 * 
	 * <p>
	 * 老师给学生录入分数，然后分别提交到后台，记录插入到数据库
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @param sub
	 * @param score
	 * @return
	 */
	@RequestMapping("/ScoreSubmit.do")
	public String ScoreSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user, SubjectTeacherStudent sub, double score) {
		String studentId = sub.getsId();
		System.out.println(studentId);
		String teacherId = sub.gettId();
		System.out.println(teacherId);
		String subjectId = sub.getSubjectId();
		System.out.println(subjectId);
		System.out.println(score);
		Score score1 = new Score();
		score1.setScore(score);
		score1.setScoreId(PrimaryKeyUtil.getPrimaryKey());
		score1.setsId(studentId);
		score1.settId(teacherId);
		score1.setSubjectId(subjectId);

		System.out.println(score1.toString());
		int c = scoreService.insertScore(score1);
		System.out.println("数据库添加记录是否成功" + c);
		return "redirect:/scoreController/listPage.do";
	}

	/***
	 * 
	 * <p>
	 * 老师查询成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/selectScore.do")
	public String selectScore(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user) {
		User u = (User) session.getAttribute("USER");
		String RoleId = u.getRoleId();
		String userId = u.getUserId();
		System.out.println("++++++++++++++" + userId);
		List<NewScore> tscore = scoreService.selectAllStudScore(userId);
		model.addAttribute("tscore", tscore);
		return "Score/teacherselectScore";
	}

	/***
	 * 
	 * <p>
	 * 老师查询成绩分页
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "teacherQueryStudlistPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView teacherSelectStudlistPage(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, HttpSession session) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		User u = (User) session.getAttribute("USER");
		String RoleId = u.getRoleId();
		String userId = u.getUserId();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<NewScore> pageResult = scoreService.teacherSelectStudByTid(pageNumber, pageSize, userId);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/teacherselectScore");
		return mv;

	}

	/***
	 * 
	 * <p>
	 * 学生查询成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月31日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/studentselectScore.do")
	public String studentselectScore(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user) {
		User u = (User) session.getAttribute("USER");
		String RoleId = u.getRoleId();
		String userId = u.getUserId();
		System.out.println("++++++++++++++" + userId);
		List<NewScore> score = scoreService.selectStudScoreById(userId);
		model.addAttribute("score", score);
		return "Score/selectScore";
	}
	@RequestMapping("/studentselectScore1.do")
	public String studentselectScore1(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		User u = (User) session.getAttribute("user");
		String RoleId = u.getRoleId();
		String userId = u.getUserId();
		System.out.println("++++++++++++++" + userId);
		List<NewScore> score = scoreService.selectStudScoreById(userId);
		model.addAttribute("score", score);
		return "score";
	}

	/***
	 * 
	 * <p>
	 * 学生查询成绩分页
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param pageSize
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "StudentQueryScorelistPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView StudentQueryScorelistPage(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, HttpSession session) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		User u = (User) session.getAttribute("USER");
		String RoleId = u.getRoleId();
		String userId = u.getUserId();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<NewScore> pageResult = scoreService.StudselectScoreById(pageNumber, pageSize, userId);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/selectScore");
		return mv;

	}
	/***
	 * 
	 * <p>
	 * 学生查询成绩后对成绩排序处理
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param pageSize
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "StudentQueryScorelistPagegroup.do", produces = "application/json;charset=utf-8")
	public ModelAndView StudentQueryScorelistPagegroup(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, HttpSession session) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		User u = (User) session.getAttribute("USER");
		String RoleId = u.getRoleId();
		String userId = u.getUserId();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<NewScore> pageResult = scoreService.StudselectScoreByIdgropu(pageNumber, pageSize, userId);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/selectScore");
		return mv;

	}

	/***
	 * 
	 * <p>
	 * 接受前台的数据并回显到修改页面
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @param scoreId
	 * @return
	 */
	@RequestMapping("/updateScore.do")
	public String updateScore(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user, String scoreId) {
		NewScore newscore = scoreService.queryselectByScoreId(scoreId);
		model.addAttribute("newscore", newscore);
		return "Score/updateScore";
	}

	/***
	 * 
	 * <p>
	 * 接收到前台修改的数据并对数据库进行修改
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @param score
	 * @param scoreId
	 * @return
	 */
	@RequestMapping("/updateScoredo.do")
	public String updateScoredo(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user, String score, String scoreId) {
		int c = scoreService.updatescore(scoreId, score);
		System.out.println("修改吃个饭饭" + c);
		System.out.println("id++++" + scoreId);
		System.out.println("分数++++" + score);

		return "redirect:/scoreController/updateScoreUllistPage.do";
	}

	/***
	 * 
	 * <p>
	 * 成绩维护
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月30日
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateScoreUl.do")
	public String updateScoreUl(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user) {
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		System.out.println("当前用户ID" + userId);
		List<NewScore> score1 = scoreService.selectAllbyUserId(userId);
		model.addAttribute("score1", score1);
		return "Score/updatedoscore";
	}

	@RequestMapping(value = "updateScoreUllistPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			HttpSession session, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		PagedResult<NewScore> pageResult = scoreService.selectAllScorebyUserId(pageNumber, pageSize, userId);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/updatedoscore");
		return mv;

	}

	/***
	 * 
	 * <p>
	 * 老师精确查询学生的成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "selectStudentByName.do", produces = "application/json;charset=utf-8")
	public ModelAndView selectStudentByName(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			HttpSession session, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, String str) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		System.out.println("老师的Id+++++++++++" + userId);
		System.out.println("学生的名字++++++++" + str);
		if (str.equals("")) {
			PagedResult<NewScore> pageResult = scoreService.querySelectStudent(pageNumber, pageSize, userId);
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/teacherselectScore");
			return mv;
		} else {
			PagedResult<NewScore> pageResult = scoreService.selectStudentByName(pageNumber, pageSize, userId, str);
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/teacherselectScore");
			return mv;
		}

		// 数据传递到前台页面展示层

	}

	/***
	 * 
	 * <p>
	 * 学生根据自己科目来精确查询自己的成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "studentselectBysbujectName.do", produces = "application/json;charset=utf-8")
	public ModelAndView studentselectBysbujectName(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, HttpSession session,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, String str) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		System.out.println("老师的Id" + userId);
		System.out.println("科目的名字" + str);
		if (str.equals("")) {
			PagedResult<NewScore> pageResult = scoreService.querySelectSubjectStudent(pageNumber, pageSize, userId);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/selectScore");
			return mv;
		} else {
			PagedResult<NewScore> pageResult = scoreService.studentselectBysbujectName(pageNumber, pageSize, userId,
					str);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/selectScore");
			return mv;
		}

	}

	/***
	 * 
	 * <p>
	 * 管理员查询所有学员成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "adminselectAllScore.do", produces = "application/json;charset=utf-8")
	public ModelAndView adminselectAllScore(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			HttpSession session, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		PagedResult<NewScore> pageResult = scoreService.adminselectAllScore(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/adminselectScore");
		return mv;
	}
	/***
	 * 
	 * <p>
	 * 管理员查询所有成绩排序
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "adminselectAllScoreGroup.do", produces = "application/json;charset=utf-8")
	public ModelAndView adminselectAllScoreGroup(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			HttpSession session, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		User u = (User) session.getAttribute("USER");
		String userId = u.getUserId();
		PagedResult<NewScore> pageResult = scoreService.adminselectAllScoreGroup(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("Score/adminselectScore");
		return mv;
	}

	/***
	 * 
	 * <p>
	 * 管理员精确查询学生的成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "adminselectStudentScore.do", produces = "application/json;charset=utf-8")
	public ModelAndView adminselectStudentScore(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, HttpSession session,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, String namestr,
			HttpServletRequest request) {
		System.out.println("------------------传统---------------------" + namestr);
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		if (namestr != null && !"".equals(namestr)) {
			session.setAttribute("namestr", namestr);
			String str1 = (String) session.getAttribute("namestr");
			System.out.println("有值吗？" + str1);
			PagedResult<NewScore> pageResult = scoreService.adminselectStudentScore(pageNumber, pageSize, str1);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/adminselectStudentScore");
			return mv;
		} else {
			PagedResult<NewScore> pageResult = scoreService.queryAdminStudent(pageNumber, pageSize);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/adminselectStudentScore");
			return mv;
		}

	}

	/***
	 * 
	 * <p>
	 * 管理员精确查找每科的学员成绩
	 * </p>
	 * 
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param session
	 * @param pageSize
	 * @param namestr
	 * @return
	 */
	@RequestMapping(value = "adminselectSubjectScore.do", produces = "application/json;charset=utf-8")
	public ModelAndView adminselectSubjectScore(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, HttpSession session,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, String subjectstr) {
		System.out.println("------------------传统---------------------");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		if (subjectstr.equals("")) {
			PagedResult<NewScore> pageResult = scoreService.queryAdminSubjectScore(pageNumber, pageSize);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/adminselectSubjectScore");
			return mv;
		} else {
			PagedResult<NewScore> pageResult = scoreService.adminselectSubjectScore(pageNumber, pageSize, subjectstr);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("Score/adminselectSubjectScore");
			return mv;
		}

	}
}
