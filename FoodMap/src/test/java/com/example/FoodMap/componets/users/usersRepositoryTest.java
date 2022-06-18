package com.example.FoodMap.componets.users;

/*import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class usersRepositoryTest {

    @Test
    void testFindUsersByEmail_PassIfSuccessfull(){

    }
}*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.FoodMap.componets.users.users;
import com.example.FoodMap.componets.users.usersRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class usersRepositoryTest {

    @Autowired
    private usersRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }


    @Test
    void testFindUsersByEmail_PassIfSuccessfull() {
        //given
        
        users u = new users();
        u.setAvalability(0);
        u.setEmail("me@gmail.com");
        u.setUser_name("hot_mom");
        u.setPassword("password");
        u.setRole("reviwer");

        underTest.save(u); 
        
        //when
        users ex =  underTest.findUsersByEmail(u.getEmail());
        //then
        assertEquals(ex, u); 
    }

    @Test
    void testFindUsersByEmail_PassIfUnsuccessfull() {
        //given
        
        users u = new users();
        u.setAvalability(0);
        u.setEmail("me@gmail.com");
        u.setUser_name("hot_mom");
        u.setPassword("password");
        u.setRole("reviwer");

        underTest.save(u); 

        users u1 = new users();
        u1.setAvalability(0);
        u1.setEmail("me1@gmail.com");
        u1.setUser_name("hot_mom");
        u1.setPassword("password");
        u1.setRole("reviwer");

        underTest.save(u1);
        
        //when
        users ex =  underTest.findUsersByEmail(u.getEmail());
        //then
        assertNotEquals(ex, u1); 
    }


    @Test
    void testGetUserByID_PassIfSuccessfull() {
        //given
        users u = new users();
        u.setAvalability(0);
        u.setEmail("me@gmail.com");
        u.setUser_name("hot_mom");
        u.setPassword("password");
        u.setRole("reviwer");

        underTest.save(u); 
        
        //when
        users ex =  underTest.getUser(u.getId());
        //then
        assertEquals(ex, u);

    }

    @Test
    void testGetUserByID_PassIfUnsuccessfull() {
        //given
        users u = new users();
        u.setAvalability(0);
        u.setEmail("me@gmail.com");
        u.setUser_name("hot_mom");
        u.setPassword("password");
        u.setRole("reviwer");

        underTest.save(u);
        
        users u1 = new users();
        u1.setAvalability(0);
        u1.setEmail("me1@gmail.com");
        u1.setUser_name("hot_mom");
        u1.setPassword("password");
        u1.setRole("reviwer");

        underTest.save(u1);
        
        //when
        users ex =  underTest.getUser(u.getId()); 
        //then
        assertNotEquals(ex, u1);

    }

    @Test
    void testGetUserEmail() {

    }

    
}
