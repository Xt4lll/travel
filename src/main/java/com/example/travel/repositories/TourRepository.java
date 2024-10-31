package com.example.travel.repositories;

import com.example.travel.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "tour")
public interface TourRepository extends JpaRepository<Tour, Integer> {
    List<Tour> findByNameContaining(String name);
}
