package com.nagarro.bookapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.bookapi.models.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Integer> {

	public Author findById(int id);
}
