package com.system.sensor.comm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class GetConnection {
	
	public static HttpURLConnection withString(String url) {
		try {
			URL u = new URL(url);
			HttpURLConnection myConection = (HttpURLConnection) u.openConnection();
			myConection.setDoOutput(true);
			myConection.setRequestProperty("Content-Type", "application/json");
			myConection.setRequestMethod("POST");
			return myConection;
		} catch (MalformedURLException e1) {
			System.out.println("URL syntax wrong");
			return null;
		} catch (IOException e2) {
			System.out.println("Connection failed");
			return null;
		}		
	}
}