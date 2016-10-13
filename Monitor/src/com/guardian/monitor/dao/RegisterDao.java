package com.guardian.monitor.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.guardian.monitor.model.Register;

@Named
@ApplicationScoped
public class RegisterDao {
	
	@PersistenceContext (name = "Guardian")
	private EntityManager em;
	
	@Transactional
	public void add(Register register) {
		em.persist(register);		
	}

}