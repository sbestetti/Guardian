package com.system.sensor.executaveis;

import java.util.Date;

import com.system.sensor.comunicacao.Sender;
import com.system.sensor.json.ParserJson;
import com.system.sensor.modelo.Evento;

public class Inicio {

	public static void main(String[] args) {
		
		Evento evento = new Evento();
		evento.setSensor(1L);
		evento.setTag(34520L);
		evento.setHorario(new Date());
		
		String json = new ParserJson().parse(evento);
		Sender.enviar(json, 1L);

	}

}
