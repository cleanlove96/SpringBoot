package com.service.system;

import java.util.List;

import com.model.system.Schedule;
import com.model.system.ScheduleResult;

public interface ScheduleService {

	int addSchedule(Schedule schedule);

	List<ScheduleResult> queryForenoonSchedule();

	List<ScheduleResult> queryAfternoonSchedule();

	Schedule queryInfo(String subjectId, String teacherId, String timeId, String placeId);

	List<ScheduleResult> queryForenoonScheduleByUserId(String userId);

	List<ScheduleResult> queryAfternoonScheduleByUserId(String userId);

	List<ScheduleResult> queryAllSchedule();

	int deleteScheduleById(String scheduleId);

}
