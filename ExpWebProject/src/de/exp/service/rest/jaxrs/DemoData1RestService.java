package de.exp.service.rest.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class DemoData
 */
@Path("/DemoData1")
public class DemoData1RestService{

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String onGet(){
		return "Demo1 Annotations: This one generates demo data on GET";
	}

}
