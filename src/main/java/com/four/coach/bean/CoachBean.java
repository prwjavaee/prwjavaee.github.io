package com.four.coach.bean;

public class CoachBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int coachId;
	private String coachName;
	private String coachJob;
	private String coachProfile;
	private String coachPic;

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

	public String getCoachJob() {
		return coachJob;
	}

	public void setCoachJob(String coachJob) {
		this.coachJob = coachJob;
	}

	public String getCoachProfile() {
		return coachProfile;
	}

	public void setCoachProfile(String coachProfile) {
		this.coachProfile = coachProfile;
	}

	public String getCoachPic() {
		return coachPic;
	}

	public void setCoachPic(String coachPic) {
		this.coachPic = coachPic;
	}

}