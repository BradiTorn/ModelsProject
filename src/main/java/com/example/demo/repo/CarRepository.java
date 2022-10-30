package com.example.demo.repo;

import com.example.demo.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByNomerContains(int nomer);
    List<Car> findByNomer(int nomer);
}
