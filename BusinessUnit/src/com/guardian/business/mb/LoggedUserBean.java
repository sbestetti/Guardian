package com.guardian.business.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.guardian.business.model.Teacher;

@Named
@SessionScoped
public class LoggedUserBean implements Serializable {

	private static final long serialVersionUID = 529518194677898594L;
	
	private Teacher loggedUser = null;
	
	//Getters & Setters
	public Teacher getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Teacher loggedUser) {
		this.loggedUser = loggedUser;
	}
	
}