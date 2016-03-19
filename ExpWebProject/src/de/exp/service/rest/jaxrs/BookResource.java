package de.exp.service.rest.jaxrs;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.exp.cdibean.BookService;
import de.exp.cdibean.stateless.NumberGenerator;
import de.exp.cdibean.stateless.qualifier.TempFile;
import de.exp.model.Book;

@Path("books/")
public class BookResource {
	
	@Inject
	private BookService bookService; 

	// ERROR: Unsatisfied dependencies for type EntityManager
	// @Inject
	private EntityManager em;

	// ISBNGenerator will be injected, because its annotated with @Default
	@Inject
	private NumberGenerator numberGenerator;

	@Path("all/")
	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Book> getAllBooks() {
		Query query = em.createNamedQuery("findAllBooks");
		List<Book> books = query.getResultList();
		return books;
	}

	@Path("isbn/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String generateISBN() {
		return numberGenerator.generateNumber();
	}

	@Inject
	@TempFile
	FileOutputStream tempFile;

	@Path("tempfile/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String generateTempFile() {
		Field pathField;
		String path = "Error";
		try {
			pathField = FileOutputStream.class.getDeclaredField("path");
			pathField.setAccessible(true);
			path = (String) pathField.get(tempFile);
			
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return path;
	}

}
