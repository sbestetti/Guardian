package com.guardian.business.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.guardian.business.dao.TeacherDao;
import com.guardian.business.model.Teacher;

@Named
@RequestScoped
public class AddUserBean {
	
	@Inject
	TeacherDao dao;
	
	private Teacher teacher = new Teacher();
	
	public String addUser() {
		int result = dao.addTeacher(teacher);		
		if (result == 0) {
			return "index.xhtml?faces-redirect=true";
		}
		return null;
	}
	
	public String cancel() {
		return "index.xhtml?faces-redirect=true";
	}

	//Getters & Setters
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}