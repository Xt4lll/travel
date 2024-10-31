package com.example.travel.repositories;

import com.example.travel.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "transport")
public interface TransportRepository extends JpaRepository<Transport, Integer> {
    List<Transport> findByTypeContaining(String type);
}
