package com.example.travel.repositories;

import com.example.travel.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "location")
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByNameContaining(String name);
}
