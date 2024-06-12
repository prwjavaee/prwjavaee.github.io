package com.four.course.bean;

public class CourseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int courseId;
	private String courseName;
	private String courseProfile;
	private int coachId;
	private String coachName;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseProfile() {
		return courseProfile;
	}

	public void setCourseProfile(String courseProfile) {
		this.courseProfile = courseProfile;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
}