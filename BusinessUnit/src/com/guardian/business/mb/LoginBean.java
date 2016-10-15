package com.guardian.business.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.guardian.business.model.Teacher;
import com.guardian.business.security.LoginUtil;

@Named
@RequestScoped
public class LoginBean {
	
	@Inject
	private LoginUtil loginUtil;
	
	@Inject
	LoggedUserBean loggedUserBean;
	
	private String login;
	private String password;
	private Teacher loggedTeacher = new Teacher();
	
	public String logon() {
		loggedTeacher = loginUtil.loginCheck(login, password);
		if (loggedTeacher == null) {
			loggedTeacher = new Teacher();
			return "index.xhtml?faces-redirect=true";
		}
		loggedUserBean.setLoggedUser(loggedTeacher);
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