package com.gamestoreapp.controller;

import com.gamestoreapp.entity.Game;
import com.gamestoreapp.serviceImpl.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth/api/library")
@CrossOrigin(origins = "http://localhost:3000")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

   
}