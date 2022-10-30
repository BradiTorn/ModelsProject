package com.example.demo.repo;

import com.example.demo.models.Marka;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarkaRepository extends CrudRepository<Marka, Long> {

}