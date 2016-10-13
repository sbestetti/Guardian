package com.system.sensor.modelo;

import java.util.Date;

public class Evento {
	
	private Long sensor;
	private Long tag;
	private Date horario;
	
	//Getters & Setters
	public Long getSensor() {
		return sensor;
	}
	public void setSensor(Long sensor) {
		this.sensor = sensor;
	}
	public Long getTag() {
		return tag;
	}
	public void setTag(Long tag) {
		this.tag = tag;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}	

}