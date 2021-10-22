package com.nagarro.bookapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.bookapi.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {

	public Book findById(int id);
}
