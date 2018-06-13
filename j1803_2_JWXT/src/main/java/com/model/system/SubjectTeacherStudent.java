/*****************************************************
 *  HISTORY
 *  FileName:SubjectTeacherStudent.java
 *  Package:com.model.system
 *  Project:j1803_2_JWXT
 *  Version:1.0
 *  Date:2018年5月29日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.model.system;

/**
 * <p>
 * 
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年5月29日
 */
public class SubjectTeacherStudent {
	private String subjectstudName;
	private String tName;
	private String sName;
	private String sId;
	private String tId;
	private String subjectId;
	private double score;
	private String majorName;
	private String className;
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectstudName() {
		return subjectstudName;
	}
	public void setSubjectstudName(String subjectstudName) {
		this.subjectstudName = subjectstudName;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "SubjectTeacherStudent [subjectstudName=" + subjectstudName + ", tName=" + tName + ", sName=" + sName
				+ ", sId=" + sId + ", tId=" + tId + ", subjectId=" + subjectId + ", score=" + score + ", majorName="
				+ majorName + ", className=" + className + "]";
	}
	
	
	

}
	