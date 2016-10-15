package com.guardian.business.dao;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.guardian.business.model.Teacher;
import com.guardian.business.security.LoginUtil;

@Named
@RequestScoped
public class TeacherDao {
	
	@Inject
	LoginUtil loginUtil;
	
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
	
	@Transactional
	public int addTeacher(Teacher teacher) {
		String hashedPassword = loginUtil.hashPassword(teacher.getPassword());
		teacher.setPassword(hashedPassword);
		teacher.setCreated(new Date());
		em.persist(teacher);
		return 0;
	}

}
