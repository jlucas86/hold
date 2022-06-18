package com.example.FoodMap.componets.restaurants;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface restaurantsRepository extends JpaRepository<restaurants, Long> {
    
    //get restaurant by id
    @Query("select r from restaurants r where r.id = ?1")
    restaurants getRestaurnt(Long id);

    //get list of restaurants that have name n
    @Query("select r from restaraunts where r.restaurant_name = ?1")
    List<restaurants> getRestaurntByName(String n);
}
