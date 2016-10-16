package com.guardian.business.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.guardian.business.dao.TeacherDao;
import com.guardian.business.model.Teacher;

@Named
@RequestScoped
public class UpdateUserBean {
	
	@Inject
	TeacherDao dao;
	
	private String nameToSearch;
	private Teacher teacher;
	private List<Teacher> resultList;
	private Boolean showResults = false;
	
	public void findTeachers() {
		resultList = dao.getTeachersByName(nameToSearch);
		this.showResults = true;
	}
	
	//Getters & Setters
	public String getNameToSearch() {
		return nameToSearch;
	}
	public void setNameToSearch(String nameToSearch) {
		this.nameToSearch = nameToSearch;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Teacher> getResultList() {
		return resultList;
	}
	public void setResultList(List<Teacher> resultList) {
		this.resultList = resultList;
	}
	public Boolean getShowResults() {
		return showResults;
	}
	public void setShowResults(Boolean showResults) {
		this.showResults = showResults;
	}	

}