package com.example.demo.repo;

import com.example.demo.models.Car;
import com.example.demo.models.Garage;
import com.example.demo.models.Parking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingRepository extends CrudRepository<Parking, Long> {

    Parking findByRackContains(String rack);

}
