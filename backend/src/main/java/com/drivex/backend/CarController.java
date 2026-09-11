package com.drivex.backend;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/api/cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/api/cars/{id}")
    public Car getCarById(@PathVariable int id) {

        return carRepository.findById(id).orElse(null);
    }
}