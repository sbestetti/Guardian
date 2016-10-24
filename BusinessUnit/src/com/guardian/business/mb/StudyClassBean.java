package com.guardian.business.mb;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.guardian.business.dao.StudentDao;
import com.guardian.business.dao.StudyClassDao;
import com.guardian.business.model.Student;
import com.guardian.business.model.StudyClass;

@Named
@RequestScoped
public class StudyClassBean {
	
	@Inject
	private StudentDao studentDao;
	
	@Inject
	private StudyClassDao classDao;
	
	private StudyClass classToAdd = new StudyClass();
	private Date start;
	private Date end;
	private DualListModel<Student> studentListModel = new DualListModel<>();
		
	@PostConstruct
	private void populateStudentList() {
		List<Student> studentSource = studentDao.getAllStudents();
		List<Student> studentTarget = new ArrayList<>();
		studentListModel.setSource(studentSource);
		studentListModel.setTarget(studentTarget);
	}
	
	public String addClass() {
		Instant instantStart = Instant.ofEpochMilli(start.getTime());
		Instant instantEnd = Instant.ofEpochMilli(end.getTime());
		classToAdd.setStartTime(LocalDateTime.ofInstant(instantStart, ZoneId.systemDefault()).toLocalTime());
		classToAdd.setEndTime(LocalDateTime.ofInstant(instantEnd, ZoneId.systemDefault()).toLocalTime());
		classDao.addStudyClass(classToAdd);
		return "main.xhtml?faces-redirect=true";
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}