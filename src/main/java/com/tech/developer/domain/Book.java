package com.tech.developer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String isbn;
	
	@Column(name = "cl_name", length = 40, nullable = false)
	private String name;
	
	@Column(name = "cl_author", length = 40,nullable = false)
	private String author;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	
	@ManyToMany
	@JoinTable(name = "book_client",
			joinColumns  = @JoinColumn(name = "book_isbn"),
			inverseJoinColumns = @JoinColumn(name = "client_id"))	
	private List<Client> clients = new ArrayList<>();
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
	
	
	
}
