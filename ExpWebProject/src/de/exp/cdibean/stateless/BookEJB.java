package de.exp.cdibean.stateless;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.exp.model.Book;

/**
 * Stateless Bean has access to EntityManager
 * @author skip
 *
 */
@Stateless
public class BookEJB {

	//ERROR: Unsatisfied dependencies for type EntityManager
//	@Inject
	EntityManager em;

	public Book findBookById(Long id) {
		return em.find(Book.class, id);
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}
}
