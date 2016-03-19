package de.exp.cdibean.stateless;

import java.util.Random;

import javax.ejb.Stateless;

import de.exp.cdibean.stateless.qualifier.NumberCalculation2002;

@Stateless
@NumberCalculation2002
public class ISSGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
