package com.guardian.monitor.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.guardian.monitor.model.Sensor;

@Stateless
public class SensorDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Sensor getSensorById(Long id) {
		return em.find(Sensor.class, id);
	}
	
}