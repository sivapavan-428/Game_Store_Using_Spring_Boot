package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.entity.Game;
import com.gamestoreapp.serviceImpl.GameService;

@RestController
@RequestMapping("/auth/api/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/add")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game savedGame = gameService.addGame(game);
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        try {
            Game game = gameService.getGameById(id);
            return ResponseEntity.ok(game);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Game> patchUpdateGame(@PathVariable Long id, @RequestBody Game updatedFields) {
        try {
            Game updatedGame = gameService.patchUpdateGame(id, updatedFields);
            return ResponseEntity.ok(updatedGame);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
        try {
            gameService.deleteGame(id);
            return ResponseEntity.ok("Game deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/getByGenre/{genre}")
    public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(gameService.getGamesByGenre(genre));
    }
}



































//
//
//package com.gamestoreapp.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.gamestoreapp.entity.Game;
//import com.gamestoreapp.serviceImpl.GameService;
//
//@RestController
//@RequestMapping("/auth/api/games")
//@CrossOrigin(origins = "http://localhost:3000")
//public class GameController {
//
//    @Autowired
//    private GameService gameService;
//
//    @PostMapping("/add")
//    public ResponseEntity<Game> addGame(@RequestPart("game") Game game,
//                                        @RequestPart("image") MultipartFile image) throws Exception {
//        Game savedGame = gameService.addGame(game, image);
//        return ResponseEntity.ok(savedGame);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Game>> getAllGames() {
//        return ResponseEntity.ok(gameService.getAllGames());
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Game> getGameById(@PathVariable Long id) throws Exception {
//        try {
//            Game game = gameService.getGameById(id);
//            return ResponseEntity.ok(game);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PatchMapping("/update/{id}")
//    public ResponseEntity<Game> patchUpdateGame(@PathVariable Long id,
//                                                @RequestPart("game") Game updatedFields,
//                                                @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
//        try {
//            Game updatedGame = gameService.patchUpdateGame(id, updatedFields, image);
//            return ResponseEntity.ok(updatedGame);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
//        try {
//            gameService.deleteGame(id);
//            return ResponseEntity.ok("Game deleted successfully!");
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/getByGenre/{genre}")
//    public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable String genre) {
//        return ResponseEntity.ok(gameService.getGamesByGenre(genre));
//    }
//}
