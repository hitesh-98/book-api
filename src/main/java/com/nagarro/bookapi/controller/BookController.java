package com.nagarro.bookapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.bookapi.models.Book;
import com.nagarro.bookapi.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> list = this.bookService.getAllBooks();

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
		}
	}

	@GetMapping(value = "/{bookCode}")
	public ResponseEntity<Book> getBookByCode(@PathVariable("bookCode") int bookCode) {

		Book book = this.bookService.getBookByCode(bookCode);

		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(book));
		}
	}

	@PostMapping(value = "/")
	public ResponseEntity<Void> addBook(@RequestBody Book book) {

		try {
			this.bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping(value = "/{bookCode}")
	public ResponseEntity<Void> deleteBookByCode(@PathVariable("bookCode") int bookCode) {

		try {
			this.bookService.deleteBookByCode(bookCode);
			return ResponseEntity.status(HttpStatus.OK).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping(value = "/{bookCode}")
	public ResponseEntity<Void> editBook(@RequestBody Book book, @PathVariable("bookCode") int bookCode) {

		try {
			this.bookService.editBook(book, bookCode);
			return ResponseEntity.status(HttpStatus.OK).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
