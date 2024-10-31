package com.example.travel.repositories;

import com.example.travel.models.modelUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<modelUser,Long> {
    modelUser findByUsername(String username);
}
