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

import com.nagarro.bookapi.models.Author;
import com.nagarro.bookapi.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Author>> getAllAuthors() {

		List<Author> list = this.authorService.getAllAuthors();

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable("id") int id) {

		Author author = this.authorService.getAuthorById(id);

		if (author == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(author));
		}
	}

	@PostMapping(value = "/")
	public ResponseEntity<Void> addAuthor(@RequestBody Author author) {

		System.out.println(author);
		try {
			this.authorService.addAuthor(author);
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAuthorById(@PathVariable("id") int id) {

		try {
			this.authorService.deleteAuthorById(id);
			return ResponseEntity.status(HttpStatus.OK).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> editAuthor(@RequestBody Author author, @PathVariable("id") int id) {

		try {
			this.authorService.editAuthor(author, id);
			return ResponseEntity.status(HttpStatus.OK).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
