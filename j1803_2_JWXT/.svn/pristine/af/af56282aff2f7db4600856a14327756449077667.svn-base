package com.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.system.Place;
import com.model.system.Schedule;
import com.model.system.ScheduleResult;
import com.model.system.Subject;
import com.model.system.Teacher;
import com.model.system.Time;
import com.model.system.User;
import com.service.system.PlaceService;
import com.service.system.ScheduleService;
import com.service.system.SubjectService;
import com.service.system.TeacherService;
import com.service.system.TimeService;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;

/**
 * 排课管理 Author JiangShan Date 2018年6月1日
 */
@Controller
@RequestMapping("/scheduleController")
public class ScheduleController extends BaseController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TimeService timeService;
	@Autowired
	private PlaceService placeService;
	@Autowired
	private ScheduleService scheduleService;

	/**  */
	private static final long serialVersionUID = -5005333482678099009L;

	/**
	 * 获取相关信息
	 * 
	 * @author JiangShan
	 * @Date 2018年6月1日
	 */
	@RequestMapping("/scheduleUI.do")
	public String scheduleUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		List<Teacher> listTeacher = teacherService.queryAllTeacher();
		List<Subject> listSubject = subjectService.queryAllSubject();
		List<Time> listTime = timeService.queryAllTime();
		List<Place> listPlace = placeService.queryAllPlace();
		model.addAttribute("listTeacher", listTeacher);
		model.addAttribute("listSubject", listSubject);
		model.addAttribute("listTime", listTime);
		model.addAttribute("listPlace", listPlace);
		return "schedule/schedule";
	}

	@RequestMapping("/verify.do")
	public void verify(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			String subjectId, String teacherId, String timeId, String placeId, int number) {
		Schedule sr = scheduleService.queryInfo(subjectId, teacherId, timeId, placeId);

		if (sr == null) {
			try {
				ServletOutputStream soss = response.getOutputStream();
				soss.print("1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				ServletOutputStream sos = response.getOutputStream();
				sos.print("0");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 提交排课信息
	 * 
	 * @author JiangShan
	 * @Date 2018年6月1日
	 */
	@SuppressWarnings({ "static-access", "unused" })
	@RequestMapping("/schedule.do")
	public String schedule(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			String subjectId, String teacherId, String timeId, String placeId, int number) {
		Schedule schedule = new Schedule();

		schedule.setScheduleId(new PrimaryKeyUtil().getPrimaryKey());
		schedule.setSubjectId(subjectId);
		schedule.settId(teacherId);
		schedule.setTimeId(timeId);
		schedule.setPlaceId(placeId);
		schedule.setTotal(number);
		int num = scheduleService.addSchedule(schedule);

		return "redirect:/scheduleController/scheduleTableUI.do";
	}

	/**
	 * 显示所有排课信息
	 * 
	 * @author JiangShan
	 * @Date 2018年6月1日
	 */
	@RequestMapping("/scheduleTableUI.do")
	public String scheduleTableUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, String subjectId, String teacherId, String timeId, String placeId) {
		User user = (User) session.getAttribute("USER");
		if (user.getRoleId().equals("1")) {
			List<ScheduleResult> listForenoonSchedule = scheduleService.queryForenoonSchedule();
			List<ScheduleResult> listAfternoonSchedule = scheduleService.queryAfternoonSchedule();
			System.out.println("scheduleTable" + listForenoonSchedule);
			model.addAttribute("listForenoonSchedule", listForenoonSchedule);
			model.addAttribute("listAfternoonSchedule", listAfternoonSchedule);
		} else if (user.getRoleId().equals("2")) {
			List<ScheduleResult> listForenoonSchedule = scheduleService.queryForenoonScheduleByUserId(user.getUserId());
			List<ScheduleResult> listAfternoonSchedule = scheduleService
					.queryAfternoonScheduleByUserId(user.getUserId());
			System.out.println("scheduleTable" + listForenoonSchedule);
			model.addAttribute("listForenoonSchedule", listForenoonSchedule);
			model.addAttribute("listAfternoonSchedule", listAfternoonSchedule);
		}

		return "schedule/schedule_table";
	}

	@RequestMapping("/scheduleTableEditUI.do")
	public String scheduleTableEditUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, String subjectId, String teacherId, String timeId, String placeId) {
		List<ScheduleResult> listAllSchedule = scheduleService.queryAllSchedule();

		for (ScheduleResult scheduleResult : listAllSchedule) {
			System.out.println("AllSchedule" + scheduleResult);
			System.out.println(scheduleResult.getSubjectName());
		}
		model.addAttribute("listAllSchedule", listAllSchedule);
		return "schedule/schedule_tableEditUI";
	}

	@SuppressWarnings("unused")
	@RequestMapping("/deleteSchedule.do")
	public String deleteSchedule(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, String scheduleId) {
		int num = scheduleService.deleteScheduleById(scheduleId);

		return "redirect:/scheduleController/scheduleTableUI.do";
	}
}
