package com.example.jwt_authentication.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.jwt_authentication.User;

@Service
public class UserService {

    private List<User> users=new ArrayList<>();

    public UserService(){
      
        users.add(new User(UUID.randomUUID().toString(),"Vaibhav Dubey","vai@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(),"Nikhil Dubey","nik@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(),"Prince Dubey","pic@gmail.com"));
    }

   public List<User> getUsers(){

    return users;
    
   }
    
}
