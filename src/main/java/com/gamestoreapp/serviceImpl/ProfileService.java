package com.gamestoreapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.repository.UserRepository;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

   
}
