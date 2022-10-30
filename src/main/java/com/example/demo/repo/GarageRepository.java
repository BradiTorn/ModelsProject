package com.example.demo.repo;

import com.example.demo.models.Car;
import com.example.demo.models.Garage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GarageRepository extends CrudRepository<Garage, Long> {

//    List<Car> findByNomerContains(int nomer);
//    List<Car> findByNomer(int nomer);
}
