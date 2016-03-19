package de.exp.service.rest.jaxrs.scoped;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * - no public methods in non @Dependent (default) scoped beans
 * - must be passivation capable
 * - @javax.inject.Named must be added to the bean to be able to resolve the bean via java-faces. Or it wont be discovered. Further registration in faces.config is not necessary
 */
@Named
@SessionScoped
public class UUIDContainerSessionScoped implements Serializable {
	private static final long serialVersionUID = -866171745569996844L;
	final String uuid = UUID.randomUUID().toString();
	
	public String getUuid() {
		return uuid;
	}
}
