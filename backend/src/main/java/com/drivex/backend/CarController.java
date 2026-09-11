package com.drivex.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // GET ALL CARS
    @GetMapping("/api/cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    // GET CAR BY ID
    @GetMapping("/api/cars/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id).orElse(null);
    }

    // ADD NEW CAR
    @PostMapping("/api/cars")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // UPDATE CAR
    @PutMapping("/api/cars/{id}")
    public Car updateCar(
            @PathVariable int id,
            @RequestBody Car updatedCar) {

        Car existingCar =
                carRepository.findById(id).orElse(null);

        if (existingCar == null) {
            return null;
        }

        existingCar.setName(updatedCar.getName());
        existingCar.setPricePerDay(updatedCar.getPricePerDay());
        existingCar.setType(updatedCar.getType());
        existingCar.setAvailability(updatedCar.getAvailability());

        return carRepository.save(existingCar);
    }

    // DELETE CAR
    @DeleteMapping("/api/cars/{id}")
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}