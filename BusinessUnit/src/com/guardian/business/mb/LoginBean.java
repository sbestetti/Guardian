package com.guardian.business.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.guardian.business.model.Teacher;
import com.guardian.business.security.LoginUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 8263656888700343703L;

	@Inject
	private LoginUtil loginUtil;
	
	private String login;
	private String password;
	private Teacher loggedTeacher = new Teacher();
	
	public String logon() {
		loggedTeacher = loginUtil.loginCheck(login, password);
		if (loggedTeacher == null) {
			loggedTeacher = new Teacher();
			return "index.xhtml?faces-redirect=true";
		}
		return "main.xhtml?faces-redirect=true";		
	}
	
	//Getters & Setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Teacher getLoggedTeacher() {
		return loggedTeacher;
	}

	public void setLoggedTeacher(Teacher loggedTeacher) {
		this.loggedTeacher = loggedTeacher;
	}	

}