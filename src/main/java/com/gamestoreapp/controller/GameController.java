//package com.gamestoreapp.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
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
//    public ResponseEntity<Game> addGame(@RequestBody Game game) {
//        Game savedGame = gameService.addGame(game);
//        return ResponseEntity.ok(savedGame);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Game>> getAllGames() {
//        return ResponseEntity.ok(gameService.getAllGames());
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
//        try {
//            Game game = gameService.getGameById(id);
//            return ResponseEntity.ok(game);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PatchMapping("/update/{id}")
//    public ResponseEntity<Game> patchUpdateGame(@PathVariable Long id, @RequestBody Game updatedFields) {
//        try {
//            Game updatedGame = gameService.patchUpdateGame(id, updatedFields);
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














package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.gamestoreapp.entity.Game;
import com.gamestoreapp.serviceImpl.GameService;
import com.gamestoreapp.serviceImpl.MinioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/auth/api/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private MinioService minioService;

    @PostMapping("/add")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game savedGame = gameService.addGame(game);
        return ResponseEntity.ok(savedGame);
    }

    @PostMapping(value = "/uploadImage/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload or update a game's image using MinIO")
    public ResponseEntity<Game> uploadGameImage(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file) throws Exception {

        if (file.isEmpty() || !file.getContentType().startsWith("image/")) {
            throw new RuntimeException("Please upload a valid image file.");
        }

        String fileName = minioService.uploadFile(file);
        String fileUrl = minioService.getFileUrl(fileName);

        Game existingGame = gameService.getGameById(id);
        existingGame.setImgUrl(fileUrl);

        Game updatedGame = gameService.updateGame(existingGame);
        return ResponseEntity.ok(updatedGame);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Game> patchUpdateGame(
            @PathVariable Long id,
            @RequestBody Game updatedFields) {
        Game updatedGame = gameService.patchUpdateGame(id, updatedFields);
        return ResponseEntity.ok(updatedGame);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(games); 
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
        List<Game> games = gameService.getGamesByGenre(genre);
        return ResponseEntity.ok(games); 
    }
}
