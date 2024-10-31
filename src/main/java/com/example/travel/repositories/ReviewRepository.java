package com.example.travel.repositories;


import com.example.travel.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "review")
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByCommentContaining(String name);
}
