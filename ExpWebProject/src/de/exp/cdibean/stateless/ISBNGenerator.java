package de.exp.cdibean.stateless;

import java.util.Random;

import javax.ejb.Stateless;

import de.exp.cdibean.stateless.qualifier.NumberCalculation2016;

@NumberCalculation2016
@Stateless
public class ISBNGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "13-84356-" + Math.abs(new Random().nextInt());
	}
}
