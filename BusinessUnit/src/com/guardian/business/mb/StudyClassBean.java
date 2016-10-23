package com.guardian.business.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.guardian.business.dao.StudentDao;
import com.guardian.business.model.Student;
import com.guardian.business.model.StudyClass;

@Named
@RequestScoped
public class StudyClassBean {
	
	@Inject
	private StudentDao studentDao;
	private StudyClass classToAdd = new StudyClass();
	private DualListModel<Student> studentListModel = new DualListModel<>();
		
	@PostConstruct
	private void populateStudentList() {
		List<Student> studentSource = studentDao.getAllStudents();
		List<Student> studentTarget = new ArrayList<>();
		studentListModel.setSource(studentSource);
		studentListModel.setTarget(studentTarget);
	}

	//Getters & Setters
	public StudyClass getClassToAdd() {
		return classToAdd;
	}

	public void setClassToAdd(StudyClass classToAdd) {
		this.classToAdd = classToAdd;
	}

	public DualListModel<Student> getStudentListModel() {
		return studentListModel;
	}

	public void setStudentListModel(DualListModel<Student> studentListModel) {
		this.studentListModel = studentListModel;
	}

}