package com.example.jwt_authentication;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserD,Integer>{

     UserD findByName(String name);
    
}
