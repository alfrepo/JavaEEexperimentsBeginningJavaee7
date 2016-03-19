package de.exp.service.rest.jaxrs.application;

import javax.ws.rs.ApplicationPath;

/**
 * Read: https://docs.jboss.org/author/display/AS7/JAX-RS+Reference+Guide
 * 
 *  ACHTUNG:  
 *  /jaxrs/ 
 *  not /jaxrs/* as you would wright in web.xml. Appending * is not necessary.
 */

@ApplicationPath("/jaxrs/")
public class TheApplication extends javax.ws.rs.core.Application {
	/* this represents the Web-applicaiton itselfe,	
	 * which contains servlets etc.
	 */
}
