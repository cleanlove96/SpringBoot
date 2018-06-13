/**
 * 
 */
package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.MenuMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Menu;
import com.model.system.MenuPN;
import com.service.system.MenuService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月29日
 */
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuMapper menuMapper;
	/**
	 * 获取菜单分页列表
	 */
	@Override
	public PagedResult<MenuPN> getMenusByPage(Integer pageNumber, Integer pageSize, String searchStyle, String keywords) {
		PageHelper.startPage(pageNumber, pageSize);
		List<MenuPN> list=null;
		if(searchStyle==null){
			list=menuMapper.findMenuPNAll();
		}else {
			switch(searchStyle) {
			case "menuName":list=menuMapper.findMenuPNLByMN(keywords);break;
			case "menuDesc":list=menuMapper.findMenuPNLByMD(keywords);break;
			case "pName":list=menuMapper.findMenuPNLByPN(keywords);break;
			default:list=menuMapper.findMenuPNAll();break;
		}
		}
		for(MenuPN m:list){
			System.err.println("-----------------------"+m);
		}
		
		return PageBeanUtil.toPagedResult(list);
	}
	/**
	 * 添加菜单
	 */
	@Override
	public void insertMenu(Menu menu) {
		menuMapper.insert(menu);
	}
	/**
	 * 通过menuId删除菜单
	 */
	@Override
	public void delMenu(String menuId) {
		menuMapper.deleteByPrimaryKey(menuId);
	}
	/**
	 * 通过menuId修改菜单
	 */
	@Override
	public void menuUpdate(Menu menu) {
		menuMapper.updateByPrimaryKey(menu);
	}
	/* (non-Javadoc)
	 * @see com.service.system.MenuService#findMenuByID(java.lang.String)
	 */
	@Override
	public Menu findMenuByID(String menuId) {
		
		return menuMapper.selectByPrimaryKey(menuId);
	}
	/* (non-Javadoc)
	 * @see com.service.system.MenuService#findMenuByPid(java.lang.String)
	 */
	@Override
	public List<Menu> findMenuByPid(String pId) {
		return menuMapper.findMenuByPid(pId);
	}
	/* (non-Javadoc)
	 * @see com.service.system.MenuService#findMenuAll()
	 */
	@Override
	public List<Menu> findMenuAll() {
		
		return menuMapper.findMenuAll();
	}
	@Override
	public List<Menu> queryAllMenuXZByUserId(String userId) {
		
		return menuMapper.queryAllMenuXZByUserId(userId);
	}
	@Override
	public List<Menu> queryMenuByUserId(String userId) {
		
		return menuMapper.queryMenuByUserId(userId);
	}
	@Override
	public List<Menu> queryMenuSelectedSonByMenuId(String menuId,String uId) {
		
		return menuMapper.queryMenuSelectedSonByMenuId(menuId,uId);
	}
	
	

}
