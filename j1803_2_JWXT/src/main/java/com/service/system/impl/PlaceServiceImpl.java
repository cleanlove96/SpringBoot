package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.PlaceMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Place;
import com.service.system.PlaceService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceMapper placeMapper;

	@Override
	public PagedResult<Place> getAllByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<Place> placelist = placeMapper.queryAllPlace();
		return PageBeanUtil.toPagedResult(placelist);
	}

	@Override
	public int addPlace(Place place) {
		// TODO Auto-generated method stub
		return placeMapper.insertSelective(place);
	}

	@Override
	public int deletePlaceById(String placeId) {
		// TODO Auto-generated method stub
		return placeMapper.deleteByPrimaryKey(placeId);
	}

	@Override
	public Place queryplaceId(String placeId) {
		// TODO Auto-generated method stub
		return placeMapper.selectByPrimaryKey(placeId);
	}

	@Override
	public int updatePlace(Place place) {
		// TODO Auto-generated method stub
		return placeMapper.updateByPrimaryKeySelective(place);
	}
	
	@Override
	public List<Place> queryAllPlace() {
		return placeMapper.queryAllPlace();
	}

	@Override
	public PagedResult<Place> queryLikeName(Integer pageNumber, Integer pageSize, String str1) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Place> placelist = placeMapper.queryLikeName(str1);
		System.out.println(placelist + "placelist");
		return PageBeanUtil.toPagedResult(placelist);
	}

}
