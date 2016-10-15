package com.guardian.business.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.guardian.business.dao.TeacherDao;
import com.guardian.business.model.Teacher;

@Named
@RequestScoped
public class LoginUtil {
	
	@Inject
	private TeacherDao dao;
	
	public Teacher loginCheck(String login, String password) {
		Teacher logged = dao.getTeacherByLogin(login);
		if (logged != null) {
			if (logged.getPassword().equals(hashPassword(password))) {
				return logged;
			}
		}		
		return null;		
	}
	
	public String hashPassword(String passwordToHash) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(passwordToHash.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff), 16)).substring(1);
			}
			return sb.toString();			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}					
	}	

}