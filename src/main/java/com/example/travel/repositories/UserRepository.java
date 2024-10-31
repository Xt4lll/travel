package com.example.travel.repositories;

import com.example.travel.models.modelUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user")
public interface UserRepository extends CrudRepository<modelUser,Long> {
    modelUser findByUsername(String username);
}
