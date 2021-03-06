package com.dao.system;

import java.util.List;

import com.model.system.Student;
import com.model.system.Subject;

public interface SubjectMapper {
    int deleteByPrimaryKey(String subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(String subjectId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 * @param subjectName
	 * @return
	 */
	Subject selectSubjectByName(String subjectName);
	
	 List<Subject> queryAllSubject();
	 List<Subject> queryLikeName(String str);
}