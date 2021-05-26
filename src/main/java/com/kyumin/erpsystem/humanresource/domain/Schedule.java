package com.kyumin.erpsystem.humanresource.domain;

public class Schedule {
	private String today;
	private String startTime;
	private String endTime;
	private double diffTime;
	private int scheduleNo;
	/**
	 * @return the today
	 */
	public String getToday() {
		return today;
	}
	/**
	 * @param today the today to set
	 */
	public void setToday(String today) {
		this.today = today;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the diffTime
	 */
	public double getDiffTime() {
		return diffTime;
	}
	/**
	 * @param diffTime the diffTime to set
	 */
	public void setDiffTime(double diffTime) {
		this.diffTime = diffTime;
	}
	/**
	 * @return the scheduleNo
	 */
	public int getScheduleNo() {
		return scheduleNo;
	}
	/**
	 * @param scheduleNo the scheduleNo to set
	 */
	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Schedule [today=" + today + ", startTime=" + startTime + ", endTime=" + endTime + ", diffTime="
				+ diffTime + "]";
	}
}
