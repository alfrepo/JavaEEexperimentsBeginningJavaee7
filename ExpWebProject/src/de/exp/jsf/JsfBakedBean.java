package de.exp.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import de.exp.cdibean.stateless.BookEJB;
import de.exp.model.Book;

@Named
public class JsfBakedBean{
	
	@Inject
	private BookEJB bookEJB;
	
	private Book book = new Book("Tom Sawyer");
	private List<Book> bookList = new ArrayList<Book>();

	public String doCreateBook(){
		book = bookEJB.createBook(book); 
		
		return "listBooks.xhtml"; // Getters, setters
	}
																																		// }
}
