package com.guardian.business.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.guardian.business.model.Teacher;

@Named
@RequestScoped
public class TeacherDao {
	
	@PersistenceContext
	private EntityManager em;

	public Teacher getTeacherByLogin(String login) {
		String jpql = "SELECT t FROM teachers t WHERE t.login = :plogin";
		TypedQuery<Teacher> query = em.createQuery(jpql, Teacher.class);
		query.setParameter("plogin", login);
		try {
			Teacher result = query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}		
	}

}
