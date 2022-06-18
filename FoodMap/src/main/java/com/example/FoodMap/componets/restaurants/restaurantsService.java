package com.example.FoodMap.componets.restaurants;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class restaurantsService {
    
    private final restaurantsRepository restaurantsRepository;

    @Autowired
    public restaurantsService(restaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public restaurants getRestaurant(Long id){
        return restaurantsRepository.getRestaurnt(id);
    }

    @Transactional
    public void addRestaurant(restaurants r) throws Exception {
        
        List<restaurants> list = restaurantsRepository.getRestaurntByName(
            r.getRestaurant_name());
        for (restaurants rest : list) 
            if( rest.getAddress() == r.getAddress() && rest.getCity() == r.getCity())
                throw new IllegalStateException("restaurant already exists");
        
        restaurantsRepository.save(r);
        
    }

    //@Transactional
    public void deleteRestaurant(restaurants r){
        Boolean exists = restaurantsRepository.existsById(r.getId());
        if(!exists)
            throw new IllegalStateException("invalid id");
        restaurantsRepository.delete(r);
    }
}
