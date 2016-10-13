package com.system.sensor.start;

import com.system.sensor.comm.Sender;
import com.system.sensor.json.ParserJson;
import com.system.sensor.model.Event;

public class Start {

	public static void main(String[] args) {
		
		Event event = new Event();
		event.setSensorId(1L);
		event.setTag(15L);
		
		String json = new ParserJson().parse(event);
		System.out.println(json);
		Sender.send(json);

	}

}
