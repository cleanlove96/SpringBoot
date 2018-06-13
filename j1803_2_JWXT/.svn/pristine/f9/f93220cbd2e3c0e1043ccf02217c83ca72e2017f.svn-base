package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.ScheduleMapper;
import com.model.system.Schedule;
import com.model.system.ScheduleResult;
import com.service.system.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Override
	public int addSchedule(Schedule schedule) {
		return scheduleMapper.insert(schedule);
	}

	@Override
	public List<ScheduleResult> queryForenoonSchedule() {
		return scheduleMapper.selectForenoonSchedule();
	}

	@Override
	public List<ScheduleResult> queryAfternoonSchedule() {
		return scheduleMapper.selectAfternoonSchedule();
	}

	@Override
	public Schedule queryInfo(String subjectId, String teacherId, String timeId, String placeId) {
		return scheduleMapper.queryInfo(subjectId,teacherId,timeId,placeId);
	}

	@Override
	public List<ScheduleResult> queryForenoonScheduleByUserId(String userId) {
		return scheduleMapper.selectForenoonScheduleByUserId(userId);
	}

	@Override
	public List<ScheduleResult> queryAfternoonScheduleByUserId(String userId) {
		return scheduleMapper.selectAfternoonScheduleByUserId(userId);
	}

	@Override
	public List<ScheduleResult> queryAllSchedule() {
		return scheduleMapper.selectAllSchedule();
	}

	@Override
	public int deleteScheduleById(String scheduleId) {
		return scheduleMapper.deleteByPrimaryKey(scheduleId);
	}
}
