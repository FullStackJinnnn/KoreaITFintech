package model;

import java.util.Date;

public class ReportDTO {
	
	private int reportNum; // PK
	private String reporter;
	private String suspect;
	private String reportContents;
	private Date reportDate;
	private Date accountStop;
	
	
	public int getReportNum() {
		return reportNum;
	}
	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public Date getAccountStop() {
		return accountStop;
	}
	public void setAccountStop(Date accountStop) {
		this.accountStop = accountStop;
	}
}
