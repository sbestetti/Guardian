package com.guardian.business.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentDao {
	
	@PersistenceContext
	EntityManager em;

}
