package com.guardian.monitor.model;

import java.util.Date;

public class Event {
	
	private Long sensorId;
	private Long tag;
	private Date timestamp;
	
	//Getters & Setters
	public Long getSensorId() {
		return sensorId;
	}
	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}
	public Long getTag() {
		return tag;
	}
	public void setTag(Long tag) {
		this.tag = tag;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}	

}