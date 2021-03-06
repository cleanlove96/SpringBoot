package com.dao.system;

import java.util.List;

import com.model.system.Choose;
import com.model.system.Course;

import framework.utils.pageUtil.PagedResult;


public interface ChooseMapper {
    int deleteByPrimaryKey(String chooseId);

    int insert(Choose record);

    int insertSelective(Choose record);

    List<Choose> selectByPrimaryKey(String chooseId);

    int updateByPrimaryKeySelective(Choose record);

    int updateByPrimaryKey(Choose record);

	List<Choose> queryChooseBysId(String sId);

	List<Course> querySubjectBysId(String sId);

	List<Course> queryScheduleAll();

	Choose queryChooseBysIdAndschedule(String sId, String scheduleId);

	List<Course> getLikeByPage(String str1);

	List<Course> getLikeByPage2(String str1);

	Choose queryChooseByTimeId(String timeId,String sId);

	List<Course> getLikeByPage3(String str1);

	List<Course> queryChooseBysIdAndTime(String sId);

	List<Course> queryChooseBysIdAndTime2(String sId);


}