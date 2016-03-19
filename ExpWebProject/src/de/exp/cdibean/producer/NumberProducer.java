package de.exp.cdibean.producer;

import java.util.Random;

import javax.enterprise.inject.Produces;

import de.exp.cdibean.stateless.qualifier.NumberCalculation2016Middle;
import de.exp.cdibean.stateless.qualifier.NumberCalculation2016Prefix;
import de.exp.cdibean.stateless.qualifier.NumberCalculation2016Random;

/**
 * This is a Producer class.
 * It only defines some injectable numbers.
 * The numbers are injected by type and name.
 * 
 * @NumberCalculation2016Prefix, @NumberCalculation2016Middle, @NumberCalculation2016Random
 * are Qualifiers - names to distinguish which String needs to be injected.
 */
public class NumberProducer {

	@Produces @NumberCalculation2016Prefix
	private String prefix13DIgits = "13-";
	
	@Produces @NumberCalculation2016Middle
	private double middleDigits = 12345;
	
	@Produces @NumberCalculation2016Random
	private int random(){
		return Math.abs(new Random().nextInt());
	}
}
