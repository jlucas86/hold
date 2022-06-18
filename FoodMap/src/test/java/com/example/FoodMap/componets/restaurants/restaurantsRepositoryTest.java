package com.example.FoodMap.componets.restaurants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;

import java.util.List;
import java.util.function.IntToLongFunction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
public class restaurantsRepositoryTest {
    
    @Autowired
    private restaurantsRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    //String restaurant_name, String food_type, Integer cost, Double rating, String address, String city, String state, Integer zipcode, Integer phone_number

    @Test
    void testGetRestaurant_PassIfSuccessfull(){
        //give
        restaurants r = new restaurants("name ._.", "butts", 
        3, 5.7, "13 elme street", "new york", "california", 20542, 1234567891L);

        underTest.save(r);
        
        //when
        restaurants ex = underTest.getRestaurnt(r.getId());
        
        //then
        assertEquals(r, ex);
    } 

    @Test
    void testGetRestaurantByName_PassIfSuccessfull(){
        //give
        restaurants r = new restaurants("name ._.", "butts", 
        3, 5.7, "13 elme street", "new york", "california", 20542, 1234567891L);
        
        restaurants r1 = new restaurants("name ._.", "butts", 
        3, 5.7, "13 elme street", "new york", "california", 20542, 1234567891L);
        
        restaurants r2 = new restaurants("name ._.", "butts", 
        3, 5.7, "14 elme street", "new york", "california", 20542, 1234567891L);

        underTest.save(r);
        underTest.save(r1);
        
        //when
        List<restaurants>  ex = underTest.getRestaurntByName(r.getRestaurant_name());
        System.out.println("sjdhfjkhsdkjhfkshdkljfhjksdkhflksjdfhjksdf  :  "+ex);
        //then
        //assertEquals(r, ex);
    }  
}
