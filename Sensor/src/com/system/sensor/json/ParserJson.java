package com.system.sensor.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.sensor.modelo.Evento;

public class ParserJson {
	
	public String parse(Evento evento){
		try {
			return new ObjectMapper().writeValueAsString(evento);
		} catch (JsonProcessingException e) {
			return null;
		}		
	}	

}