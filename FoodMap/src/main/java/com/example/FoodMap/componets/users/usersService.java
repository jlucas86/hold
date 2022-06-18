package com.example.FoodMap.componets.users;

import javax.transaction.Transactional;

import com.example.FoodMap.componets.exceptions.emailExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usersService {
    
    private final usersRepository usersRepository;

    @Autowired
    public usersService(usersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public users getUser(Long id){
        return usersRepository.getUser(id);
    }

    @Transactional
    public void addUser(users u) throws Exception {
        if(usersRepository.findUsersByEmail(u.getEmail()) == null)
            throw new Exception("email taken");
        usersRepository.save(u);
    }

    public void deleteUser(Long id){
        Boolean exists = usersRepository.existsById(id);
        if(!exists)
            throw new IllegalStateException("invalid id");
        usersRepository.deleteById(id);
    }

}
