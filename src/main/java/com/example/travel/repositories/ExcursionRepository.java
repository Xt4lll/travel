package com.example.travel.repositories;

import com.example.travel.models.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "excursion")
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    List<Excursion> findByNameContaining(String name);
}