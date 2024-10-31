package com.example.travel.repositories;

import com.example.travel.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "hotel")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByNameContaining(String name);
}
