
package com.controller.system;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.system.Menu;
import com.model.system.MenuPN;
import com.service.system.MenuService;

import framework.utils.pageUtil.PagedResult;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月29日
 */

//菜单控制层
@Controller
@RequestMapping("/menuController")
public class MenuController {
	@Autowired
	private MenuService menuService; 
	
	//菜单列表显示与数据处理
	@RequestMapping("/listPage.do")
	public String menuList(HttpServletRequest request,HttpSession session,Model model,@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,String searchStyle,String keywords) {
		System.err.println("---------------------menu-listPage---");
		if(searchStyle!=null) {
			session=request.getSession();
			session.setAttribute("searchStyle", searchStyle);
			session.setAttribute("keywords", keywords);
		}
		searchStyle=(String) session.getAttribute("searchStyle");
		keywords=(String) session.getAttribute("keywords");
		System.out.println(searchStyle+":"+keywords);
		PagedResult<MenuPN> pagedResult =menuService.getMenusByPage(pageNumber,pageSize,searchStyle,keywords);
		model.addAttribute("pagedResult",pagedResult);
		return "system/menu_list";
	}
	
	/**
	 * 菜单添加
	 * @return
	 */
	@RequestMapping("/menuAddUI.do")
	public String menuAddUI(Model model){
		System.err.println("---------------------menu-menuAddUI---");
		List<Menu> menuList=menuService.findMenuAll();
		model.addAttribute("menuList", menuList);
		model.addAttribute("menuList", menuList);
		return "system/menu_add";
	}
	@RequestMapping("/menuAdd.do")
	public String menuAdd(Menu menu) {
		System.err.println("---------------------menu-menuAdd---");
		if(menu!=null){
			menu.setMenuId(UUID.randomUUID().toString());
			menu.setCreateTime(new Date());
			menuService.insertMenu(menu);
		}
		return "redirect:listPage.do";
	}
	/**
	 * 菜单单个删除
	 * @return
	 */
	@RequestMapping("/menuDel.do")
	public String menuDel(String menuId) {
		System.err.println("---------------------menu-menuDel---");
		menuService.delMenu(menuId);
		return "redirect:listPage.do";
	}
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/menusDel")
	public String menusDel(String[] ids) {
		for(String id:ids) {
			System.err.println("---------------------menu-menusDel---"+id);
			menuService.delMenu(id);
		}
		return "redirect:listPage.do";
	}
	/**
	 * 菜单修改界面跳转
	 * @param ids
	 * @return
	 */
	@RequestMapping("menuUpdateUI.do")
	public String menuUpdateUI(Model model,String menuId) {
		List<Menu> menuList=menuService.findMenuAll();
		model.addAttribute("menuList", menuList);
		Menu menu=menuService.findMenuByID(menuId);
		model.addAttribute("menu", menu);
		return "system/menu_update";
	}
	/**
	 * 菜单修改
	 * @param ids
	 * @return
	 */
	@RequestMapping("menuUpdate.do")
	public String menuUpdate(Menu menu) {
		menuService.menuUpdate(menu);
		return "redirect:listPage.do";
		
	}
}
