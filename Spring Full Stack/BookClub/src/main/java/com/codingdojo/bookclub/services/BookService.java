package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {

	// Inject repository
	@Autowired
	private BookRepository bookRepo;
	
	// Constructor
	public BookService(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	// Get a list of all books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// Find one book 
	public Book findBook(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		}else {
			return null;
		}
	}
	
	// Create a Book from repo 
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	// Delete a Book from repo 
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	// Update a Book from repo
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
}
