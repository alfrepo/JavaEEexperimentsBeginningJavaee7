package de.exp.model;

import java.util.Date;

public class Book {
	 String name;
	 double price;
	 String description;
	 String isbn;
	 Date instanciationsDate;
	
	public Book(String name) {
		this.name = name;
	}
	
	public Book(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	public void setInstanciationDate(Date instanciationsDate){
		this.instanciationsDate = instanciationsDate;
	}
}

