package com.example.demo.repo;

import com.example.demo.models.Garage;
import com.example.demo.models.Parking;
import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends CrudRepository<Parking, Long> {
}
