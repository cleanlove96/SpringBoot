/*****************************************************
 *  HISTORY
 *  FileName:ScoreService.java
 *  Package:com.service.system
 *  Project:j1803_2_JWXT
 *  Version:1.0
 *  Date:2018年5月29日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.service.system;

import java.util.List;

import com.model.system.NewScore;
import com.model.system.Score;

import framework.utils.pageUtil.PagedResult;

/**
 * <p>
 * 
 * </p>	
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
public interface ScoreService {

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月29日
	 * @param score
	 */
	int insertScore(Score score);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @return 
	 * @Date 2018年5月29日
	 */
	List<NewScore> selectAllScore();

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @param userId 
	 * @Date 2018年5月30日
	 * @return
	 */
	List<NewScore> selectAllStudScore(String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param userId
	 * @return
	 */
	List<NewScore> selectStudScoreById(String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param tId
	 * @param sId
	 * @param subjectId
	 * @return
	 */
	NewScore querySelectById(String tId, String sId, String subjectId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param scoreId
	 * @param score
	 */
	int updatescore(String scoreId, String score);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param userId
	 * @return
	 */
	List<NewScore> selectAllbyUserId(String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param scoreId
	 * @return
	 */
	NewScore queryselectByScoreId(String scoreId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月30日
	 * @param studentId
	 * @param teacherId
	 * @param subjectId
	 * @return
	 */
	int selectBySidTidSubjectid(String studentId, String teacherId, String subjectId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<NewScore> teacherSelectStudByTid(Integer pageNumber, Integer pageSize, String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<NewScore> StudselectScoreById(Integer pageNumber, Integer pageSize, String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年5月31日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<NewScore> selectAllScorebyUserId(Integer pageNumber, Integer pageSize, String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @param pageSize 
	 * @param pageNumber 
	 * @Date 2018年5月31日
	 * @param userId
	 * @param str
	 * @return
	 */
	PagedResult<NewScore> selectStudentByName(Integer pageNumber, Integer pageSize, String userId, String str);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @param str
	 * @return
	 */
	PagedResult<NewScore> studentselectBysbujectName(Integer pageNumber, Integer pageSize, String userId, String str);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PagedResult<NewScore> adminselectAllScore(Integer pageNumber, Integer pageSize);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param pageSize
	 * @param namestr
	 * @return
	 */
	PagedResult<NewScore> adminselectStudentScore(Integer pageNumber, Integer pageSize, String namestr);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月1日
	 * @param pageNumber
	 * @param pageSize
	 * @param subjectstr
	 * @return
	 */
	PagedResult<NewScore> adminselectSubjectScore(Integer pageNumber, Integer pageSize, String subjectstr);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月3日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<NewScore> querySelectStudent(Integer pageNumber, Integer pageSize, String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月3日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<NewScore> querySelectSubjectStudent(Integer pageNumber, Integer pageSize, String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月3日
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PagedResult<NewScore> queryAdminStudent(Integer pageNumber, Integer pageSize);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月3日
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PagedResult<NewScore> queryAdminSubjectScore(Integer pageNumber, Integer pageSize);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PagedResult<NewScore> StudselectScoreByIdgropu(Integer pageNumber, Integer pageSize, String userId);

	/**
	 * <p>
	 * 
	 * </p>
	 * @author zm
	 * @Date 2018年6月4日
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PagedResult<NewScore> adminselectAllScoreGroup(Integer pageNumber, Integer pageSize);




}
