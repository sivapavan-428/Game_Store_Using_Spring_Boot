package com.gamestoreapp.serviceImpl;

import com.gamestoreapp.entity.Game;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.repository.GameRepository;
import com.gamestoreapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

   
}