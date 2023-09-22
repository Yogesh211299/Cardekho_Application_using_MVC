package com.jspiders.cardekhoapplicationusingmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhoapplicationusingmvc.pojo.AdminPojo;

@Repository
public class AdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	
	
	public static void openConnection() {
		factory=Persistence.createEntityManagerFactory("Car");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	public static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	
	
	public AdminPojo getAdmin() {
       openConnection();
       transaction.begin();
       String findAdmin="from AdminPojo";
       query=manager.createQuery(findAdmin);
       List<AdminPojo> admins=query.getResultList();
      
       if (admins.isEmpty()==false) {
    	   for(AdminPojo pojo:admins) {
        	   transaction.commit();
               closeConnection();
               return pojo;
           }
	   }
      
       transaction.commit();
       closeConnection();
       return null;
	}

	public AdminPojo createAccountAdmin(String username, String password) {
      openConnection();
      transaction.begin();
      
      AdminPojo pojo=new AdminPojo();
      pojo.setUsername(username);
      pojo.setPassword(password);
      
      manager.persist(pojo);
      transaction.commit();
      closeConnection();
		return pojo;
	}

	public AdminPojo login(String username, String password) {

		openConnection();
		transaction.begin();
		
		String findAdmin="from AdminPojo where username = '"+username+"' and password = '"+password+"'";
		query=manager.createQuery(findAdmin);
		List<AdminPojo> admins=query.getResultList();
		if (admins.isEmpty()==false) {
			for(AdminPojo pojo:admins) {
				transaction.commit();
				closeConnection();
				return pojo;
			}
		}
		transaction.commit();
		closeConnection();
		return null;
	}

}
