package com.tech.developer.start;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.tech.developer.domain.Book;
import com.tech.developer.domain.Client;
import com.tech.developer.domain.Publisher;
import com.tech.developer.domain.Sin;
import com.tech.developer.util.ConnectionFactory;

public class Main {

	public static void main(String[] args) {
		
		test();
		
	
	}
	
	
	
	
	public static void test() {
		
		EntityManager em = ConnectionFactory.getEntityManager();
		
		EntityTransaction trans  = em.getTransaction();
		
		try {
			trans.begin();
			
			String sql = "SELECT b FROM Book b WHERE  b.author LIKE '%c%' ORDER BY b.id";
			
			TypedQuery<Book> q = em.createQuery(sql,Book.class);
			
			q.getResultList().forEach(e -> System.out.println(e));
			
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			trans.rollback();
		}
		
		
		
		em.close();
		System.out.println("closed connection");
	}
	
	
	public static void persistValues(EntityManager em) {
		
		
		EntityTransaction trans  = em.getTransaction();
		
		
		
		try {
			
			trans.begin();
			
			
			Sin s1 = new Sin();
			s1.setNumber("0001");
			s1.setDate(LocalDate.now());
			
			em.persist(s1);
					
			Client c1 = new Client();
			c1.setName("Emma");
			c1.setSin(s1);
			s1.setClient(c1);
			
			em.persist(c1);
			
			Sin s2 = new Sin();
			s2.setNumber("0002");
			s2.setDate(LocalDate.now());
					
			em.persist(s2);
			
			Client c2 = new Client();
			c2.setName("Lea");
			c2.setSin(s2);
			s2.setClient(c2);
			
			em.persist(c2);
			
			Sin s3 = new Sin();
			s3.setNumber("0003");
			s3.setDate(LocalDate.now());
			
			em.persist(s3);
					
			Client c3 = new Client();
			c3.setName("Jade");
			c3.setSin(s3);
			s3.setClient(c3);
			
			em.persist(c3);
			
			Publisher p1 = new Publisher();
			p1.setName("Oracle press");
			
			em.persist(p1);
			
			Publisher p2 = new Publisher();
			p2.setName("Microsoft press");
			
			em.persist(p2);
					
			Publisher p3 = new Publisher();
			p3.setName("Apple press");
			
			em.persist(p3);
			
			Publisher p4 = new Publisher();
			p4.setName("Google press");
			
			em.persist(p4);
			
			Publisher p5 = new Publisher();
			p5.setName("Amazon press");
			
			em.persist(p5);
			
			Book b1 = new Book();
			b1.setName("Java");
			b1.setAuthor("Oracle");
			b1.setIsbn("0001");
			b1.setPublisher(p1);
			p1.getBooks().add(b1);
			
			em.persist(b1);
			
			Book b2 = new Book();
			b2.setName("C#");
			b2.setAuthor("Microsof");
			b2.setIsbn("0002");
			b2.setPublisher(p2);
			p2.getBooks().add(b2);
			p2.getBooks().add(b1);
			
			em.persist(b2);
			
			Book b3 = new Book();
			b3.setName("Object C");
			b3.setAuthor("Apple");
			b3.setIsbn("0003");
			b3.setPublisher(p3);
			p3.getBooks().add(b3);
			p3.getBooks().add(b2);
			
			em.persist(b3);
			
			Book b4 = new Book();
			b4.setName("Google");
			b4.setAuthor("Go");
			b4.setIsbn("0004");
			b4.setPublisher(p4);
			p4.getBooks().add(b4);
			p4.getBooks().add(b3);
					
			em.persist(b4);
			
			Book b5 = new Book();
			b5.setName("Amazon");
			b5.setAuthor("AWS");
			b5.setIsbn("0005");
			b5.setPublisher(p5);
			p5.getBooks().add(b5);
			p5.getBooks().add(b4);		
			
			em.persist(b5);
			
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			trans.rollback();
		}
		
	
				
		
	}


	

}
