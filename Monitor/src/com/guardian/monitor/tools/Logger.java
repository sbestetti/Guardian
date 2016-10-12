package com.guardian.monitor.tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.guardian.monitor.model.Event;

public abstract class Logger {
		
	public static void logEvent(Event event) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fullMessage = df.format(new Date()) + "," + event.getSensorId() + "," + event.getTag(); 
		try {
			FileWriter fw = new FileWriter("EventLog.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(fullMessage);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void logSystem(String msg) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fullMessage = df.format(new Date()) + "," + msg; 
		try {
			FileWriter fw = new FileWriter("SystemLog.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(fullMessage);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}