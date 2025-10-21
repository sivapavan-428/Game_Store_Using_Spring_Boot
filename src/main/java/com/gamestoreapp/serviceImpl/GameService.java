
package com.gamestoreapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestoreapp.entity.Game;
import com.gamestoreapp.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game addGame(Game game) {
        assignSection(game);
        return gameRepository.save(game);
    }

    public Game updateGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + id));
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public Game patchUpdateGame(Long id, Game updatedFields) {
        Game game = getGameById(id);

        if (updatedFields.getName() != null) game.setName(updatedFields.getName());
        if (updatedFields.getDescription() != null) game.setDescription(updatedFields.getDescription());
        if (updatedFields.getPrice() != null) game.setPrice(updatedFields.getPrice());
        if (updatedFields.getDiscount() != null) game.setDiscount(updatedFields.getDiscount());
        if (updatedFields.getGenres() != null && !updatedFields.getGenres().isEmpty())
            game.setGenres(updatedFields.getGenres());
        if (updatedFields.getImgUrl() != null) game.setImgUrl(updatedFields.getImgUrl());
        if (updatedFields.getSectionKey() != null) game.setSectionKey(updatedFields.getSectionKey().toUpperCase());

        if (updatedFields.getPrice() != null || updatedFields.getSectionKey() != null) {
            assignSection(game);
        }

        return gameRepository.save(game);
    }

    public List<Game> getGamesByGenre(String genre) {
        return gameRepository.findByGenresContainingIgnoreCase(genre);
    }

    private void assignSection(Game game) {
        if (game.getPrice() != null && game.getPrice() == 0) {
            game.setSectionKey("FREE");
        } else if (game.getPrice() == null) {
            game.setSectionKey("FEATURED");
        } else if (game.getSectionKey() != null) {
            game.setSectionKey(game.getSectionKey().toUpperCase());
        }
    }
    
    public Game save(Game game) {
        return gameRepository.save(game);
    }
}
