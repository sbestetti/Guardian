package com.guardian.monitor.api;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.guardian.monitor.dao.RegisterDao;
import com.guardian.monitor.model.Event;
import com.guardian.monitor.model.Register;
import com.guardian.monitor.tools.Logger;

@Path ("listener")
public class Listener {
	
	@Inject
	RegisterDao dao;
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response eventListener(Event event) {
		Register register = new Register();
		register.setSensorId(event.getSensorId());
		register.setTag(event.getTag());
		register.setTimestamp(new Date());
		Logger.logEvent(event);
		dao.add(register);
		return Response.status(200).build();		
	}

}