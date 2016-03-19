package de.exp.cdibean.stateless;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import de.exp.cdibean.stateless.qualifier.NumberCalculation2016Middle;
import de.exp.cdibean.stateless.qualifier.NumberCalculation2016Prefix;
import de.exp.cdibean.stateless.qualifier.NumberCalculation2016Random;

// @Stateless annotation is not needed!

@Default
public class ISBNGeneratorWithProducer implements NumberGenerator {

	/**
	 * Injecting those variables is possible, because there are @Produces annotations in NumberProducer.class
	 */
	
	@Inject @NumberCalculation2016Prefix
	String prefix;
	
	@Inject @NumberCalculation2016Middle
	double middle;
	
	@Inject @NumberCalculation2016Random
	int random;
	
	@Override
	public String generateNumber() {
		return prefix + middle + random;
	}
}

