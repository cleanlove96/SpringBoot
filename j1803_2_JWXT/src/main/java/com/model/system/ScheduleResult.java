package com.model.system;

public class ScheduleResult {
	private String subjectName;

    private String tName;

    private String timeName;

    private String placeName;
    
    private String scheduleId;
    
    private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getTimeName() {
		return timeName;
	}

	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public ScheduleResult() {
		super();
	}

	public ScheduleResult(String subjectName, String tName, String timeName, String placeName, String scheduleId,
			int total) {
		super();
		this.subjectName = subjectName;
		this.tName = tName;
		this.timeName = timeName;
		this.placeName = placeName;
		this.scheduleId = scheduleId;
		this.total = total;
	}
	
}
