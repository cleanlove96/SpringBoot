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

import com.model.system.Place;
import com.service.system.PlaceService;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * �Ͽεص�
 * </p>
 * 
 * @Copyright (C),����Զ��
 * @author LGH
 * @Date:2018��5��16��
 */
@Controller
@RequestMapping("/placeController")
public class PlaceController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1963590751247885669L;
	@Autowired
	private PlaceService placeService;

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
	 * @param place
	 * @return
	 */
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		System.out.println("------------------��ͳ---------------------");
		ModelAndView mv = new ModelAndView();
		// ��ǰҳ��ÿҳ������
		// �������ݵ���ҳ������
		PagedResult<Place> pageResult = placeService.getAllByPage(pageNumber, pageSize);
		// ���ݴ��ݵ�ǰ̨ҳ��չʾ��
		mv.addObject("pageResult", pageResult);
		mv.setViewName("place/place_list");
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
	 * @param place
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Place place) {
		place.setPlaceId(PrimaryKeyUtil.getPrimaryKey());
		int n = placeService.addPlace(place);
		return "redirect:/placeController/listPage.do";
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
	 * @param place
	 * @param String
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Place place, String placeId) {
		int m = placeService.deletePlaceById(placeId);
		return "redirect:/placeController/listPage.do";
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
	 * @param place
	 * @param String
	 * @return
	 */
	@RequestMapping("updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Place place, String placeId) {
		Place p = placeService.queryplaceId(placeId);
		model.addAttribute("place", p);
		return "place/place_update";
	}

	@RequestMapping("update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Place place, String placeId) {
		int mm = placeService.updatePlace(place);
		return "redirect:/placeController/listPage.do";
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
	 * @param place
	 * @param String
	 * @return
	 */
	@RequestMapping(value = "/deleteMany.do")
	public String deleteMany(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Place place, String[] ids) {
		if (ids == null) {
			return "redirect:/placeController/listPage.do";
		}
		for (String id : ids) {
			int m = placeService.deletePlaceById(id);
		}
		return "redirect:/placeController/listPage.do";
	}

	@RequestMapping(value = "search.do", produces = "application/json;charset=utf-8")
	public ModelAndView search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, HttpSession session,
			HttpServletRequest request, String str) {
		ModelAndView mv = new ModelAndView();
		if (str != null) {
			String like = request.getParameter("str");
			session.setAttribute("str", like);
		}
		String str1 = (String) session.getAttribute("str");
		// 当前页和每页的条数
		// 传入数据到分页工具类
		System.out.println("str1" + str1);
		PagedResult<Place> pageResult = placeService.queryLikeName(pageNumber, pageSize, str1);
		// 数据传递到前台页面展示层
		System.out.println(pageResult + "pageResult");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("place/place_list");
		return mv;

	}

}
