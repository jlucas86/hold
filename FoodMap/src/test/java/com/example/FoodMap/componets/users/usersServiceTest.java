package com.example.FoodMap.componets.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.example.FoodMap.componets.users.users;
import com.example.FoodMap.componets.users.usersRepository;
import com.example.FoodMap.componets.users.usersService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class usersServiceTest {
    
    @Mock
    private usersRepository usersRepository;
    //private AutoCloseable autoCloseable;       not needed due to top anotation
    
    private usersService underTest;

    @BeforeEach
    void setUp(){
        //autoCloseable =  MockitoAnnotations.openMocks(this);  not needed due to top anotation
        underTest = new usersService(usersRepository);
    }

    /*@AfterEach                                    not needed due to top anotation
    void tearDown() throws Exception{
        autoCloseable.close();
    }*/

    @Test
    public void canGetUserById() {
        //when
        Long i = Long.valueOf(1);
        underTest.getUser(i);
        //then
        verify(usersRepository).getUser(i);      
    }

    @Test
    public void canAddUser() throws Exception {
        //given
        users u = new users();
        u.setAvalability(0);
        u.setEmail("me@gmail.com");
        u.setUser_name("hot_mom");
        u.setPassword("password");
        u.setRole("reviwer"); 
        
        //when
        underTest.addUser(u);
        
        //then
        ArgumentCaptor<users> userArgumentCaptor = 
            ArgumentCaptor.forClass(users.class);

        verify(usersRepository).save(userArgumentCaptor.capture());

        users capturedUser = userArgumentCaptor.getValue();
        assertEquals(capturedUser, u);
        System.out.println(capturedUser.getId());
    }

    @Test
    public void throwsExeptionWhenEmailIsTaken() throws Exception{
        //given
        users u = new users();
        u.setAvalability(0);
        u.setEmail("me@gmail.com");
        u.setUser_name("hot_mom");
        u.setPassword("password");
        u.setRole("reviwer"); 

        users u1 = new users();
        u1.setAvalability(0);
        u1.setEmail("meslkdfj@gmail.com");
        u1.setUser_name("hot_mom");
        u1.setPassword("password");
        u1.setRole("reviwer"); 
        
        //when
        //then

        BDDMockito.given(usersRepository.findUsersByEmail(u.getEmail())).willReturn(u1);
        Exception exception = assertThrows(Exception.class, () -> {
            underTest.addUser(u);
        });
        System.out.println(exception);
        
        verify(usersRepository, never()).save(any());
    }
}
