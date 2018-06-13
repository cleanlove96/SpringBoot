package com.dao.system;

import java.util.List;

import com.model.system.Schedule;
import com.model.system.ScheduleResult;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String scheduleId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String scheduleId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

	List<ScheduleResult> selectForenoonSchedule();

	List<ScheduleResult> selectAfternoonSchedule();

	Schedule queryInfo(String subjectId, String teacherId, String timeId, String placeId);

	List<ScheduleResult> selectForenoonScheduleByUserId(String userId);

	List<ScheduleResult> selectAfternoonScheduleByUserId(String userId);

	List<ScheduleResult> selectAllSchedule();

	ScheduleResult queryScheduleById(String scheduleId);
}