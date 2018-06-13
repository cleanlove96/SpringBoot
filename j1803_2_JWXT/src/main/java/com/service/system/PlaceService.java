package com.service.system;

import java.util.List;

import com.model.system.Place;

import framework.utils.pageUtil.PagedResult;

public interface PlaceService {

	PagedResult<Place> getAllByPage(Integer pageNumber, Integer pageSize);

	int addPlace(Place place);

	int deletePlaceById(String placeId);

	Place queryplaceId(String placeId);

	int updatePlace(Place place);

	PagedResult<Place> queryLikeName(Integer pageNumber, Integer pageSize, String str1);

	/**
	 * @return
	 */
	List<Place> queryAllPlace();

}
