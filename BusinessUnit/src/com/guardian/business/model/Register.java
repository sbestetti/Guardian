package com.guardian.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the registers database table.
 * 
 */
@Entity
@Table(name="registers")
@NamedQuery(name="Register.findAll", query="SELECT r FROM Register r")
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private BigInteger sensorId;

	private BigInteger tag;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public Register() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getSensorId() {
		return this.sensorId;
	}

	public void setSensorId(BigInteger sensorId) {
		this.sensorId = sensorId;
	}

	public BigInteger getTag() {
		return this.tag;
	}

	public void setTag(BigInteger tag) {
		this.tag = tag;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}