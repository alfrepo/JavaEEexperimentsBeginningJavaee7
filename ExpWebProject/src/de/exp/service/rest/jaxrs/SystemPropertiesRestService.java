package de.exp.service.rest.jaxrs;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// where to expose this service?
@Path("System/properties")
public class SystemPropertiesRestService {

	// provide some information on "GET" requests
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getSystemProperties() {
		Map<String, String> result = new HashMap<>();
		Properties props = System.getProperties();

		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			result.put((String) entry.getKey(), (String) entry.getValue());
		}

		return result;
	}
	
	@POST
	@Consumes("text/plain")
	public void postClichedMessage(String message) {
	    // Store the message
	}

}