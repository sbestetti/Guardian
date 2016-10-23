package com.guardian.business.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.guardian.business.model.Student;

@Named
@RequestScoped
public class StudentDao {
	
	@Inject
	private StudyClassDao classDao;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public int addStudent(Student student, Long studyClassId) {
		student.setStudyClass(classDao.getClassById(studyClassId));
		em.persist(student);
		return 0;
	}
	
	public List<Student> getStudentByName(String name) {
		String jpql = "SELECT s FROM students s WHERE name LIKE :pname";
		TypedQuery<Student> query = em.createQuery(jpql, Student.class);
		query.setParameter("pname", "%" + name + "%");
		return query.getResultList();
	}
	
	public List<Student> getAllStudents() {
		return em.createQuery("SELECT s FROM students s", Student.class).getResultList();
	}

}
