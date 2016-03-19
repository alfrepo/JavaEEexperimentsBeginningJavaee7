package de.exp.intercept;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("interceptors/")
public class InterceptorsService {
	
	@Inject
	private JanBean janBean; 

	@Inject
	private TigerBean tigerBean;
	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doSomeInterceptedThings() {
		StringBuffer stringBuffer = new StringBuffer();
		janBean.meow(stringBuffer);
		stringBuffer.append("\n");
		tigerBean.meow(stringBuffer);
		return stringBuffer.toString();
	}



}
