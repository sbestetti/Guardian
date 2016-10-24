package com.guardian.monitor.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.guardian.monitor.dao.RegisterDao;
import com.guardian.monitor.dao.SensorDao;
import com.guardian.monitor.model.Event;
import com.guardian.monitor.model.Register;
import com.guardian.monitor.model.Sensor;
import com.guardian.monitor.tools.Logger;

@Path ("listener")
public class Listener {
	
	@Inject
	private RegisterDao registerDao;
	
	@Inject
	private SensorDao sensorDao;
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response eventListener(Event event) {
		Register register = new Register();
		Sensor sensor = sensorDao.getSensorById(event.getSensorId());
		if (sensor == null) {
			Logger.logSystem("Sensor " + event.getSensorId() + " not registered. Register ignored");
			return Response.status(400).entity("Sensor not registered. Operation dropped.").build();
		}
		register.setSensor(sensor);
		register.setTag(event.getTag());
		register.setTimestamp(event.getTimestamp());
		Logger.logEvent(event);
		try {
			registerDao.add(register);
			return Response.status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400).entity("Database error. Check SystemLog.txt").build();			
		}
	}

}