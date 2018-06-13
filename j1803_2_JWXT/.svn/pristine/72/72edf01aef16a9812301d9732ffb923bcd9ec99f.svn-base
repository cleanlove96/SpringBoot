package com.dao.system;

import java.util.List;

import com.model.system.Place;
import com.model.system.Student;

public interface PlaceMapper {
    int deleteByPrimaryKey(String placeId);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(String placeId);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
    
    List<Place> queryAllPlace();
    List<Place> queryLikeName(String str);
}