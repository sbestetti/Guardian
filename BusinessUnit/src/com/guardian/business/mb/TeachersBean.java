package com.guardian.business.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.guardian.business.dao.TeacherDao;
import com.guardian.business.model.Teacher;

@ManagedBean
@ViewScoped
public class TeachersBean implements Serializable{
	
	private static final long serialVersionUID = -7237143706799126055L;

	@Inject
	private TeacherDao dao;
	
	private String nameToSearch;
	private List<Teacher> results;
	private Boolean showResults = false;
	private Boolean showEditForm = false;
	private Boolean disableEditFields = true;
	private Teacher teacherToEdit = new Teacher();
	
	public void updateResults() {
		results = dao.getTeachersByName(nameToSearch);
		showResults = true;
	}
	
	public void editTeacher(Teacher teacher) {
		teacherToEdit = teacher;
		showEditForm = true;
	}
	
	public void enableEditFields() {
		disableEditFields = false;
	}
	
	public String cancelEdit() {
		return "main.xhtml?faces-redirect=true";
	}

	//Getters & Setters
	public String getNameToSearch() {
		return nameToSearch;
	}

	public void setNameToSearch(String nameToSearch) {
		this.nameToSearch = nameToSearch;
	}

	public List<Teacher> getResults() {
		return results;
	}

	public void setResults(List<Teacher> results) {
		this.results = results;
	}

	public Boolean getShowResults() {
		return showResults;
	}

	public void setShowResults(Boolean showResults) {
		this.showResults = showResults;
	}

	public Boolean getShowEditForm() {
		return showEditForm;
	}

	public void setShowEditForm(Boolean showEditForm) {
		this.showEditForm = showEditForm;
	}

	public Boolean getDisableEditFields() {
		return disableEditFields;
	}

	public void setDisableEditFields(Boolean disableEditFields) {
		this.disableEditFields = disableEditFields;
	}

	public Teacher getTeacherToEdit() {
		return teacherToEdit;
	}

	public void setTeacherToEdit(Teacher teacherToEdit) {
		this.teacherToEdit = teacherToEdit;
	}	
	
}