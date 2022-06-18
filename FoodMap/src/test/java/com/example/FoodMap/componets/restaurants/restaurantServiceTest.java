package com.example.FoodMap.componets.restaurants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class restaurantServiceTest {
    @Mock
    private restaurantsRepository restaurantsRepository;

    private restaurantsService underTest;

    @BeforeEach
    void setUp(){
        underTest = new restaurantsService(restaurantsRepository);
    }

    @Test
    public void canGetRestaurantById() {
        //when
        Long i = 1l;
        underTest.getRestaurant(i);
        
        //then
        verify(restaurantsRepository).getRestaurnt(i);
    }

    @Test
    public void canNotGetRestaurantById() {
        //given
        //when
        //then
    }

    @Test
    public void canAddRestaurant() throws Exception{
        //given
        restaurants r = new restaurants("name ._.", "butts", 
        3, 5.7, "13 elme street", "new york", "california", 20542, 1234567891L);
        
        //when
        underTest.addRestaurant(r);

        //then
        ArgumentCaptor<restaurants> restaurantArgumentCaptor =
            ArgumentCaptor.forClass(restaurants.class);
        
        verify(restaurantsRepository).save(restaurantArgumentCaptor.capture());

        restaurants capturedRestaurant = restaurantArgumentCaptor.getValue();
        assertEquals(capturedRestaurant, r);


    }

    @Test
    public void canNotAddRestaurant(){
        //given
        //when
        //then
    }

    // will fail untill figured out how to bipass check if
    // restaurant exists
    @Test
    public void canDeleteRestaurant() throws Exception{
        //given
        restaurants r = new restaurants(10l, "name ._.", "butts", 
        3, 5.7, "13 elme street", "new york", "california",
        20542, 1234567891L);

        //when
        underTest.deleteRestaurant(r);

        //then

        ArgumentCaptor<restaurants> restaurantArgumentCaptor =
            ArgumentCaptor.forClass(restaurants.class);
        
        verify(restaurantsRepository).delete(restaurantArgumentCaptor.capture());

        restaurants capturedRestaurant = restaurantArgumentCaptor.getValue();
        assertEquals(capturedRestaurant, r);
    }

    @Test
    public void canNotDeleteRestaurant(){
        //given
        //when
        //then
    }

}
