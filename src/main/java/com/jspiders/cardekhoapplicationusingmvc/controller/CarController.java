package com.jspiders.cardekhoapplicationusingmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekhoapplicationusingmvc.pojo.AdminPojo;
import com.jspiders.cardekhoapplicationusingmvc.pojo.CarPojo;
import com.jspiders.cardekhoapplicationusingmvc.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService service;
	
	
	@RequestMapping(path = "/home",method = RequestMethod.GET)
	public String homePage(ModelMap map,@SessionAttribute(name="login",required = false) AdminPojo admin) {
		if (admin != null) {
			return"Home";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	@GetMapping("/addCar")
	public String addPage(@SessionAttribute(name = "login", required = false)AdminPojo admin,ModelMap map) {
		if (admin != null) {
			return"AddCar";	
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
		
	}
	@PostMapping("/addCar")
	public String addCar(@SessionAttribute(name = "login", required = false)AdminPojo admin,@RequestParam String name,@RequestParam String model,
			             @RequestParam String fuelType,@RequestParam double price, ModelMap map) {
		if (admin != null) {
			CarPojo pojo=service.addCar(name,model,fuelType,price);
			if (pojo != null) {
				map.addAttribute("msg","Car Details added successfully ..!");
				return"AddCar";
			}
			map.addAttribute("msg","Car Details not added ..!");
			return"AddCar";	
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	@GetMapping("/searchCar")
	public String searchCarPage(@SessionAttribute(name = "login", required = false)AdminPojo admin,ModelMap map) {
		if (admin != null) {
			return "SearchCar";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	@PostMapping("/searchCar")
	public String searchCar(@SessionAttribute(name = "login", required = false)AdminPojo admin,@RequestParam int id ,ModelMap map) {
		if (admin != null) {
		CarPojo pojo=service.searchCar(id);
		if (pojo != null) {
			map.addAttribute("car",pojo);
			return"SearchCar";
		}
		map.addAttribute("msg","Car data not founded");
		return "SearchCar";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	@GetMapping("/updateCar")
	public String updateCarPage(@SessionAttribute(name = "login", required = false)AdminPojo admin,ModelMap map) {
		if (admin != null) {
		List<CarPojo> cars=service.findAllCars();
		if (cars != null) {
			map.addAttribute("cars",cars);
			return "UpdateCar";
		}
		map.addAttribute("msg","No record available..!");
		return"UpdateCar";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name = "login", required = false)AdminPojo admin,@RequestParam int id,ModelMap map) {
		if (admin != null) {
		CarPojo pojo=service.searchCar(id);
		List<CarPojo> cars=service.findAllCars();
		if (pojo == null) {
			map.addAttribute("msg","Car Data not found");
			map.addAttribute("cars",cars);
           return"UpdateCar";
		}
		map.addAttribute("car",pojo);
		return"UpdateCar";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	@PostMapping("/updateCarDetails")
	public String updateCar1(@SessionAttribute(name = "login", required = false)AdminPojo admin,@RequestParam String name,@RequestParam int id,@RequestParam String fuelType,
			                @RequestParam String model,@RequestParam double price,ModelMap map) {
        if (admin != null) {
		CarPojo pojo=service.updateCar(id,name,model,fuelType,price);
		List<CarPojo> cars=service.findAllCars();
		if (pojo != null) {
			map.addAttribute("msg","Car Details Updated successfully..!");
			map.addAttribute("cars",cars);
			return"UpdateCar";
		}
		map.addAttribute("msg","Car Details not Updated..!");
		map.addAttribute("cars",cars);
		return"UpdateCar";
        }
        map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	
	@GetMapping("/removeCar")
	public String removeCarPage(@SessionAttribute(name = "login", required = false)AdminPojo admin,ModelMap map) {
		if (admin != null) {
		List<CarPojo> cars=service.findAllCars();
		
		if (cars != null) {
			map.addAttribute("cars",cars);
			return"RemoveCar";
		}
		map.addAttribute("msg","No record available..!");
		return "RemoveCar";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
	@PostMapping("/removeCar")
	public String removeCar(@SessionAttribute(name = "login", required = false)AdminPojo admin,@RequestParam int id,ModelMap map) {
		if (admin != null) {
		CarPojo pojo=service.removeCar(id);
		List<CarPojo> cars=service.findAllCars();
		if (pojo != null) {
		map.addAttribute("cars",cars);
		map.addAttribute("msg","Car removed successfully..!");
		return"RemoveCar";
		}
		map.addAttribute("cars",cars);
		map.addAttribute("msg","Car not Removed..!");
		return"RemoveCar";
		}
		map.addAttribute("msg","Session inactive.  please login  ");
		return "Login";
	}
	
}
