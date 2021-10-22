package com.nagarro.bookapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.bookapi.dao.BookRepo;
import com.nagarro.bookapi.models.Book;

@Component
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	// get all books
	public List<Book> getAllBooks() {
		return (List<Book>) this.bookRepo.findAll();
	}

	// get book by code
	public Book getBookByCode(int bookCode) {
		Book book = null;

		try {
			book = this.bookRepo.findById(bookCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	// add new book
	public void addBook(Book book) {
		this.bookRepo.save(book);
	}

	// delete book by code
	public void deleteBookByCode(int bookCode) {
		this.bookRepo.deleteById(bookCode);
	}

	// edit book details
	public void editBook(Book book, int bookCode) {
		book.setBookCode(bookCode);
		this.bookRepo.save(book);
	}

}
