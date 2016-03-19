package de.exp.service.rest.jaxrs.scoped;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class UUIDContainerRequestScoped implements Serializable {
	private static final long serialVersionUID = -8213777292865507299L;
	final String uuid = UUID.randomUUID().toString();
	
	public String getUuid() {
		return uuid;
	}
}
