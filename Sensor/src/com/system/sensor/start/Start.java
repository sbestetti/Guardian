package com.system.sensor.start;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import com.system.sensor.comm.GetConnection;
import com.system.sensor.comm.Sender;
import com.system.sensor.json.ParserJson;
import com.system.sensor.model.Event;

public class Start {

	public static void main(String[] args) throws MalformedURLException {
		
		String sensorId = args[0];
		String tag = args[1];
		
		Event event = new Event();
		
		String url = "http://localhost:8080/monitor/api/listener";				
		
		System.out.println("Registering. Please wait...");
		
		HttpURLConnection con = GetConnection.withString(url);
		event.setSensorId(Long.valueOf(sensorId));
		event.setTag(Long.valueOf(tag));
		String json = new ParserJson().parse(event);
		Sender.send(con, json);
	}

}