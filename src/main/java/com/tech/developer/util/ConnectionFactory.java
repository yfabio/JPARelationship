package com.tech.developer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class ConnectionFactory {
	
	private  ConnectionFactory() {} 
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager  getEntityManager() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("keysaver");
		}
		return entityManagerFactory.createEntityManager();
	}
	
}
