package com.nagarro.bookapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;

	private String authorName;

	public Author() {
		super();
	}

	public Author(int id, String authorName) {
		super();
		this.authorId = id;
		this.authorName = authorName;
	}

	public int getId() {
		return authorId;
	}

	public void setId(int id) {
		this.authorId = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [id=" + authorId + ", authorName=" + authorName + "]";
	}

}
