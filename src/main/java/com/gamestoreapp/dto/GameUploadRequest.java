
package com.gamestoreapp.dto;

import com.gamestoreapp.entity.Game;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

@Schema(name = "GameUploadRequest", description = "Game data with optional image file")
public class GameUploadRequest {

    @Schema(description = "Game JSON data")
    private Game game;

    @Schema(type = "string", format = "binary", description = "Game image file")
    private MultipartFile file;

    // getters and setters
    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }
}
