package com.system.sensor.start;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Random;

import com.system.sensor.comm.GetConnection;
import com.system.sensor.comm.Sender;
import com.system.sensor.json.ParserJson;
import com.system.sensor.model.Event;

public class Start {

	public static void main(String[] args) throws MalformedURLException {
		
		int counter;
		
		if (args.length == 0) {
			counter = 100;
		} else {
			counter = Integer.valueOf(args[0]);			
		}		 
				
		Date end = new Date();
				
		Event event = new Event();
		
		Date start = new Date();
		
		String url = "http://localhost:8080/Monitor/api/listener";				
		
		System.out.println("Registering. Please wait...");
		
		for (int i = 0; i < counter; i++) {
			HttpURLConnection con = GetConnection.withString(url);
			event.setSensorId((new Random().nextLong()));
			event.setTag(new Random().nextLong());
			String json = new ParserJson().parse(event);
			Sender.send(con, json);			
		}
		
		end.setTime(new Date().getTime() - start.getTime());
		
		System.out.println("Events registered: " + counter);
		System.out.println("Total operation time: " + end.getTime() / 1000 + " seconds");
		System.out.println("Average time per event: " + end.getTime() / counter + " miliseconds");

	}

}