package com.example.demo.repo;

import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

//    List<User> findByUsernameContains(String username);
//    List<User> findByUsername(String username);
    User findByUsername(String username);

}