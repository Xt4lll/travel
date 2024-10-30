package com.example.travel.repositories;

import com.example.travel.models.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
