package com.nagarro.bookapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.bookapi.dao.AuthorRepo;
import com.nagarro.bookapi.models.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	public List<Author> getAllAuthors() {
		return (List<Author>) this.authorRepo.findAll();
	}

	public Author getAuthorById(int id) {
		Author author = null;

		try {
			author = this.authorRepo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return author;
	}

	public void addAuthor(Author author) {
		System.out.println(author);
		this.authorRepo.save(author);
	}

	public void deleteAuthorById(int id) {
		this.authorRepo.deleteById(id);
	}

	public void editAuthor(Author author, int id) {
		author.setId(id);
		this.authorRepo.save(author);
	}

}
