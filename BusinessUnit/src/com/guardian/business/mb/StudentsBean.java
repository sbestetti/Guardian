package com.guardian.business.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.guardian.business.dao.StudentDao;
import com.guardian.business.dao.StudyClassDao;
import com.guardian.business.model.Student;
import com.guardian.business.model.StudyClass;

@ManagedBean
@ViewScoped
public class StudentsBean {
	
	@Inject
	private StudentDao dao;
	
	@Inject
	private StudyClassDao classDao;
		
	private String nameToSearch;
	private List<Student> searchResults;
	private Boolean showResults = false;
	private Boolean showEditForm = false;
	private Boolean disableEditFields = true;
	private Student studentToEdit;
	private Student studentToAdd = new Student();
	private Long tagToAdd;
	private Long classToAdd;
	private List<Long> listOfTags;
	private List<StudyClass> listOfClasses;
	
	@PostConstruct
	private void populateListOfClasses() {
		listOfClasses = classDao.getClasses();
	}
	
	
	public void addTags() {
		listOfTags.add(tagToAdd);
	}
	
	public String addStudent() {
		dao.addStudent(studentToAdd, classToAdd);
		return "main.xhtml?faces-redirect=true";
	}
	
	public void updateResults() {
		searchResults = dao.getStudentByName(nameToSearch);
		showResults = true;		
	}
	
	public void editStudent(Student student) {
		studentToEdit = student;
		showEditForm = true;
	}
	
	public void enableEditFields() {
		disableEditFields = false;
	}
	
	
	
	//Getters & Setters
	public List<Student> getStudentsList() {
		return dao.getStudentByName(nameToSearch);
	}

	public String getNameToSearch() {
		return nameToSearch;
	}

	public void setNameToSearch(String nameToSearch) {
		this.nameToSearch = nameToSearch;
	}

	public List<Student> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Student> searchResults) {
		this.searchResults = searchResults;
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

	public Student getStudentToEdit() {
		return studentToEdit;
	}

	public void setStudentToEdit(Student studentToEdit) {
		this.studentToEdit = studentToEdit;
	}

	public Boolean getDisableEditFields() {
		return disableEditFields;
	}

	public void setDisableEditFields(Boolean disableEditFields) {
		this.disableEditFields = disableEditFields;
	}

	public Student getStudentToAdd() {
		return studentToAdd;
	}

	public void setStudentToAdd(Student studentToAdd) {
		this.studentToAdd = studentToAdd;
	}

	public List<Long> getListOfTags() {
		return listOfTags;
	}

	public void setListOfTags(List<Long> listOfTags) {
		this.listOfTags = listOfTags;
	}

	public Long getTagToAdd() {
		return tagToAdd;
	}

	public void setTagToAdd(Long tagToAdd) {
		this.tagToAdd = tagToAdd;
	}


	public List<StudyClass> getListOfClasses() {
		return listOfClasses;
	}


	public void setListOfClasses(List<StudyClass> listOfClasses) {
		this.listOfClasses = listOfClasses;
	}


	public Long getClassToAdd() {
		return classToAdd;
	}


	public void setClassToAdd(Long classToAdd) {
		this.classToAdd = classToAdd;
	}	

}