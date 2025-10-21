
package com.gamestoreapp.controller;

import com.gamestoreapp.entity.Game;
import com.gamestoreapp.serviceImpl.GameService;
import com.gamestoreapp.serviceImpl.MinioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/auth/api/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private MinioService minioService;

    @PostMapping("/add")
    @Operation(summary = "Add a new game")
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

    @PatchMapping(value = "/update/{id}", consumes = "multipart/form-data")
    @Operation(summary = "Update game fields and/or image")
    public ResponseEntity<Game> updateGame(
            @PathVariable Long id,
            @RequestPart("game") Game updatedFields,
            @RequestPart(value = "file", required = false) MultipartFile file) throws Exception {

        Game existingGame = gameService.getGameById(id);

        if (file != null && !file.isEmpty()) {
            String folderPrefix = "game_covers/";
            String fileName = minioService.uploadFile(file, folderPrefix);
            String fileUrl = minioService.generatePresignedUrl(fileName);
            existingGame.setImgUrl(fileUrl);
        }

       
        if (updatedFields.getName() != null) existingGame.setName(updatedFields.getName());
        if (updatedFields.getDescription() != null) existingGame.setDescription(updatedFields.getDescription());
        if (updatedFields.getPrice() != null) existingGame.setPrice(updatedFields.getPrice());
        if (updatedFields.getDiscount() != null) existingGame.setDiscount(updatedFields.getDiscount());
        if (updatedFields.getGenres() != null && !updatedFields.getGenres().isEmpty())
            existingGame.setGenres(updatedFields.getGenres());

        Game updatedGame = gameService.updateGame(existingGame);
        return ResponseEntity.ok(updatedGame);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a game")
    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
        try {
            gameService.deleteGame(id);
            return ResponseEntity.ok("Game deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByGenre/{genre}")
    @Operation(summary = "Get games by genre")
    public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(gameService.getGamesByGenre(genre));
    }

    @PostMapping(value = "/uploadImage/{id}", consumes = "multipart/form-data")
    @Operation(summary = "Upload or update a game's image using MinIO")
    public ResponseEntity<Game> uploadGameImage(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file) throws Exception {

        if (file.isEmpty() || !file.getContentType().startsWith("image/")) {
            throw new RuntimeException("Please upload a valid image file.");
        }

        String folderPrefix = "game_covers/";
        String fileName = minioService.uploadFile(file, folderPrefix);
        String fileUrl = minioService.generatePresignedUrl(fileName);

        Game existingGame = gameService.getGameById(id);
        existingGame.setImgUrl(fileUrl);

        Game updatedGame = gameService.updateGame(existingGame);
        return ResponseEntity.ok(updatedGame);
    }
}
