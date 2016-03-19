package de.exp.cdibean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.exp.cdibean.stateless.NumberGenerator;
import de.exp.cdibean.stateless.qualifier.NumberCalculation2002;
import de.exp.cdibean.stateless.qualifier.NumberCalculation2016;
import de.exp.model.Book;

public class BookService {
	
	@Inject
	@NumberCalculation2002
	private NumberGenerator numberGeneratorOld;
	
	@Inject
	@NumberCalculation2016
	private NumberGenerator numberGeneratorNew;
	
	// @Default annotated implementation will be injected
	@Inject
	private NumberGenerator numberGeneratorDefault;
	
	

	// ERROR: Unsatisfied dependencies for type EntityManager
//	@Inject
	private EntityManager em;

	private Date instanciationDate;

	@PostConstruct
	private void initDate() {
		instanciationDate = new Date();
	}

	@Transactional
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGeneratorDefault.generateNumber());
		book.setInstanciationDate(instanciationDate);
		em.persist(book);
		return book;
	}
}
