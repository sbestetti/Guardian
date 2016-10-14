package com.guardian.business.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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
	
	private static final String saltBase = "nbimIqhAIvwc8F0gp8bX";
	
	public Teacher loginCheck(String login, String password) {
		Teacher logged = dao.getTeacherByLogin(login);
		if (logged != null) {
			if (logged.getPassword().equals(hashPassword(password))) {
				return logged;
			}
		}		
		return null;		
	}
	
	public String hashPassword(String password) {
		String finalPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(getSalt());
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff), 16)).substring(1);
			}
			finalPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			finalPassword = null;
		}		
		//TODO: Remove messages
		System.out.println("Final password: " + finalPassword);
		return finalPassword;		
	}
	
	private byte[] getSalt() {
		SecureRandom sr;
		byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance(saltBase);
			sr.nextBytes(salt);
			//TODO: Remove messages
			System.out.println("Final salt: " + salt);
			return salt;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return null;	
	}		
		
}