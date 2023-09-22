package com.jspiders.cardekhoapplicationusingmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhoapplicationusingmvc.pojo.CarPojo;

@Repository
public class CarRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private Query query;

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("Car");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
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

	public CarPojo addCar(String name, String model, String fuelType, double price) {
		openConnection();
		transaction.begin();
		CarPojo pojo = new CarPojo();
		pojo.setName(name);
		pojo.setModel(model);
		pojo.setFuelType(fuelType);
		pojo.setPrice(price);

		manager.persist(pojo);

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPojo searchCar(int id) {
		openConnection();
		transaction.begin();

		CarPojo pojo = manager.find(CarPojo.class, id);

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPojo updateCar(int id, String name, String model, String fuelType, double price) {
		openConnection();
		transaction.begin();
         
		CarPojo pojo=manager.find(CarPojo.class,id);
		pojo.setName(name);
		pojo.setModel(model);
		pojo.setFuelType(fuelType);
		pojo.setPrice(price);
		
		manager.persist(pojo);
		transaction.commit();
		closeConnection();

		return pojo;
	}

	public List<CarPojo> findAllCars() {
openConnection();
transaction.begin();

String findCars="from CarPojo";
query=manager.createQuery(findCars);
List<CarPojo>cars=query.getResultList();

transaction.commit();
closeConnection();
				
		return cars;
	}

	public CarPojo removeCar(int id) {
openConnection();
transaction.begin();

  CarPojo pojo=manager.find(CarPojo.class,id);
  if (pojo != null) {
	  manager.remove(pojo);
}
  
transaction.commit();
closeConnection();
		return pojo;
	}

}
