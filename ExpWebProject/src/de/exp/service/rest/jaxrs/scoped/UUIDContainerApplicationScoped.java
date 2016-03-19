package de.exp.service.rest.jaxrs.scoped;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * - no public methods in non @Dependent (default) scoped beans:
 * http://stackoverflow.com/questions/10179825/public-field-in-java - must be
 * passivation capable - @javax.inject.Named must be added to the bean to be
 * able to resolve the bean via java-faces. Or it wont be discovered. Further
 * registration in faces.config is not necessary
 */
@Named
@ApplicationScoped
public class UUIDContainerApplicationScoped implements Serializable {
	private static final long serialVersionUID = 8865190099826190510L;
	final String uuid = UUID.randomUUID().toString();

	public String getUuid() {
		return uuid;
	}

}
