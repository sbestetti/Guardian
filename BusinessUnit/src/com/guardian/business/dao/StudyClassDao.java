package com.guardian.business.dao;

import java.util.ArrayList;
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
	
	public List<String> getClassesNames() {
		String jpql = "SELECT c FROM classes c";
		TypedQuery<StudyClass> query = em.createQuery(jpql, StudyClass.class);
		List<StudyClass> fullList = query.getResultList();
		List<String> result = new ArrayList<>();
		for (StudyClass studyClass : fullList) {
			result.add(studyClass.getDescription());
		}
		return result;		
	}

}
