package com.example.travel.repositories;

import com.example.travel.models.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "guide")
public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findByNameContaining(String title);
}
