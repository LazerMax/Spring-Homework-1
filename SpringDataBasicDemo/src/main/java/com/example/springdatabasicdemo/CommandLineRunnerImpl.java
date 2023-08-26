package com.example.springdatabasicdemo;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BikeRepository bikeRepository;
    private final CarRepository carRepository;
    private final PlaneRepository planeRepository;
    private final TruckRepository truckRepository;
    private final VehicleRepository vehicleRepository;

    public CommandLineRunnerImpl(BikeRepository bikeRepository, CarRepository carRepository, PlaneRepository planeRepository,
                                 TruckRepository truckRepository, VehicleRepository vehicleRepository) {
        this.bikeRepository = bikeRepository;
        this.carRepository = carRepository;
        this.planeRepository = planeRepository;
        this.truckRepository = truckRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        printALLBikes();
        printAllCars();
        printAllPlanes();
        printAllTrucks();
        printAllVechicals();

    }

    private void printALLBikes() {
        bikeRepository
                .findAll()
                .forEach(System.out::println);
    }

    private void printAllCars() {
        carRepository
                .findAll()
                .forEach(System.out::println);
    }

    private void printAllTrucks() {
        truckRepository
                .findAll()
                .forEach(System.out::println);
    }

    private void printAllPlanes() {
        planeRepository
                .findAll()
                .forEach(System.out::println);
    }
    private void printAllVechicals() {
        vehicleRepository
                .findAll()
                .forEach(System.out::println);
    }


    private void seedData() throws IOException {
        //Добавление в БД записей
        Car car1 = new Car("Sedan","Reno B35", BigDecimal.valueOf(364100),"oil95",4);
        Plane plane1 = new Plane("passenger's","Л-42М",BigDecimal.valueOf(3500000),"aviation gasolines",4);
        Truck truck1 = new Truck("cargo","Scania S-Series, 2020",BigDecimal.valueOf(2134545),"Disel",19000.0);
        Bike bike1 = new Bike("Castom","Harley-Davidson Softail Custom, 2007",BigDecimal.valueOf(138747308),"Petrol");

        carRepository.save(car1);
        planeRepository.save(plane1);
        truckRepository.save(truck1);
        bikeRepository.save(bike1);
    }
}
