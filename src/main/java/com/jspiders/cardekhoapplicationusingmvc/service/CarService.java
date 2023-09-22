package com.jspiders.cardekhoapplicationusingmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhoapplicationusingmvc.pojo.CarPojo;
import com.jspiders.cardekhoapplicationusingmvc.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	public CarPojo addCar(String name, String model, String fuelType, double price) {
		CarPojo pojo = repository.addCar(name, model, fuelType, price);
		return pojo;
	}

	public CarPojo searchCar(int id) {
		CarPojo pojo = repository.searchCar(id);
		return pojo;
	}

	public CarPojo updateCar(int id, String name, String model, String fuelType, double price) {
        CarPojo pojo=repository.updateCar(id,name,model,fuelType,price);
		return pojo;
	}

	public List<CarPojo> findAllCars() {
     List< CarPojo> cars=repository.findAllCars();
		return cars;
	}

	public CarPojo removeCar(int id) {
       CarPojo pojo=repository.removeCar(id);
		return pojo;
	}

}
