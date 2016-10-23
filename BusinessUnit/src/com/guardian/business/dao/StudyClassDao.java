package com.guardian.business.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.guardian.business.model.StudyClass;

@Named
@RequestScoped
public class StudyClassDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<StudyClass> getClasses() {
		String jpql = "SELECT c FROM classes c";
		TypedQuery<StudyClass> query = em.createQuery(jpql, StudyClass.class);
		return query.getResultList();				
	}
	
	public StudyClass getClassById(Long id) {
		String jpql = "SELECT c FROM classes c WHERE id=:pid";
		TypedQuery<StudyClass> query = em.createQuery(jpql, StudyClass.class);
		query.setParameter("pid", id);
		return query.getSingleResult();		
	}

}