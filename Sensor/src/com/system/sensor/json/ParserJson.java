package com.system.sensor.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.sensor.model.Event;

public class ParserJson {
	
	public String parse(Event event){
		try {
			return new ObjectMapper().writeValueAsString(event);
		} catch (JsonProcessingException e) {
			return null;
		}		
	}	

}