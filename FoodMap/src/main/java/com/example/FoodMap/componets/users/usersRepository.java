package com.example.FoodMap.componets.users;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<users, Long> {
    
    @Query("select u from users u where u.id = ?1")
    users getUser(Long id);

    @Query("select u from users u where u.email = ?1")
    users findUsersByEmail(String email);

    @Query("select u from users u where u.email = ?1")
    users getUserEmail(String email);
}
