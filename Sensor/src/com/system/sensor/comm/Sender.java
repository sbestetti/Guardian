package com.system.sensor.comm;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class Sender {
		
	public static void send(HttpURLConnection myConnection, String json) throws MalformedURLException {
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(myConnection.getOutputStream());
			writer.write(json);
			writer.flush();
			System.out.println("HTTP Response: " + myConnection.getResponseCode());
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
}