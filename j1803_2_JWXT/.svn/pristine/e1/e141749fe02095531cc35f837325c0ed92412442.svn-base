
package com.controller.system;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.system.Menu;
import com.model.system.Role;
import com.model.system.RoleMenu;
import com.service.system.MenuService;
import com.service.system.RoleService;

import framework.utils.pageUtil.PagedResult;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月29日
 */

//角色控制层
@Controller
@RequestMapping("/roleController")
public class RoleController {
	@Autowired
	private RoleService roleService; 
	@Autowired
	private MenuService menuService; 
	//角色列表显示与数据处理
	@RequestMapping("/listPage.do")
	public String roleList(HttpServletRequest request,HttpSession session,Model model,@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,String searchStyle,String keywords) {
		System.err.println("---------------------role-listPage---");
		if(searchStyle!=null) {
			session=request.getSession();
			session.setAttribute("searchStyle", searchStyle);
			session.setAttribute("keywords", keywords);
		}
		searchStyle=(String) session.getAttribute("searchStyle");
		keywords=(String) session.getAttribute("keywords");
		System.out.println(searchStyle+":"+keywords);
		PagedResult<Role> pagedResult =roleService.getRolesByPage(pageNumber,pageSize,searchStyle,keywords);
		model.addAttribute("pagedResult",pagedResult);
		return "system/role_list";
	}
	
	/**
	 * 角色添加
	 * @return
	 */
	@RequestMapping("/validateRID.do")
	public void validateRID(String roleId,HttpServletResponse response){
		System.err.println("---------------------validateRID---");
		ServletOutputStream  out=null;
		try {
			out=response.getOutputStream();
			
			if(roleId!=null) {
				Role role=roleService.findRoleByID(roleId);
				if(role!=null) {
					out.print("error");
				}else {
					out.print("sucess");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	@RequestMapping("/roleAddUI.do")
	public String roleAddUI(){
		
		System.err.println("---------------------role-roleAddUI---");
		return "system/role_add";
	}
	@RequestMapping("/roleAdd.do")
	public String roleAdd(Role role) {
		System.err.println("---------------------role-roleAdd---");
		if(role!=null){
			//role.setRoleId(UUID.randomUUID().toString());
			role.setCreateTime(new Date());
			roleService.insertRole(role);
		}
		return "redirect:listPage.do";
	}
	/**
	 * 角色单个删除
	 * @return
	 */
	@RequestMapping("/roleDel.do")
	public String roleDel(String roleId) {
		System.err.println("---------------------role-roleDel---");
		roleService.delRole(roleId);
		return "redirect:listPage.do";
	}
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rolesDel")
	public String rolesDel(String[] ids) {
		for(String id:ids) {
			System.err.println("---------------------role-rolesDel---"+id);
			roleService.delRole(id);
		}
		return "redirect:listPage.do";
	}
	/**
	 * 角色修改界面跳转
	 * @param ids
	 * @return
	 */
	@RequestMapping("roleUpdateUI.do")
	public String roleUpdateUI(Model model,String roleId) {
		Role role=roleService.findRoleByID(roleId);
		model.addAttribute("role", role);
		return "system/role_update";
	}
	/**
	 * 角色修改
	 * @param ids
	 * @return
	 */
	@RequestMapping("roleUpdate.do")
	public String roleUpdate(Role role) {
		roleService.roleUpdate(role);
		return "redirect:listPage.do";
		
	}
	/**
	 * 角色分配界面跳转
	 * @param ids
	 * @return
	 */
	@RequestMapping("roleFpMenuUI.do")
	public String roleFpMenuUI(Model model,String roleId) {
		Role role=roleService.findRoleByID(roleId);
		model.addAttribute("role", role);
		List<Menu> menuList=menuService.findMenuAll();
		model.addAttribute("menuList", menuList);
		List<RoleMenu> roleMenuList=roleService.findRoleMenuByRid(roleId);
		model.addAttribute("roleMenuList", roleMenuList);
		return "system/role_fp_menu";
	}
	/**
	 * 角色分配
	 * @param ids
	 * @return
	 */
	@RequestMapping("roleFpMenu.do")
	public String roleFpMenu(String roleId,String[] menuIds) {
		roleService.delRoleMenuByRid(roleId);
		for(String menuId:menuIds ) {
			RoleMenu roleMenu=new RoleMenu();
			roleMenu.setRoleMenuId(UUID.randomUUID().toString());
			roleMenu.setMenuId(menuId);
			roleMenu.setRoleId(roleId);
			roleService.insertRoleMenu(roleMenu);
		}
		
		return "redirect:listPage.do";
		
	}
}
