package de.exp.service.rest.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("GPS/")
public class MyGpsCoordinatesRestService {

	@GET
	@Path("zug/")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getZugGpsCoordinates(){
		Map<String, String> m = new HashMap<>();
		m.put("y", "47.177546");
		m.put("x", "8.430578");
		return m;
	}
	
	@GET
	@Path("aachen/")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getAachenGpsCoordinates(){
		Map<String, String> m = new HashMap<>();
		m.put("y", "50.7709398");
		m.put("x", "6.0704648");
		return m;
	}
}
