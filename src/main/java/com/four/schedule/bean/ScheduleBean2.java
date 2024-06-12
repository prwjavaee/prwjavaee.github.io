package com.four.schedule.bean;

public class ScheduleBean2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String[] scheduleIds;
	private String[] weekdays;
	private String[] daytimes;
	private String courseId;
	private String courseName;
	private String coachId;
	private String coachName;
	public String[] getScheduleIds() {
		return scheduleIds;
	}
	public void setScheduleIds(String[] scheduleIds) {
		this.scheduleIds = scheduleIds;
	}
	public String[] getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(String[] weekdays) {
		this.weekdays = weekdays;
	}
	public String[] getDaytimes() {
		return daytimes;
	}
	public void setDaytimes(String[] daytimes) {
		this.daytimes = daytimes;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoachId() {
		return coachId;
	}
	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	

}