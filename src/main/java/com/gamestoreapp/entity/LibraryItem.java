package com.gamestoreapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "library")
public class LibraryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long gameId;

    private String gameName;

    public LibraryItem() {}

    public LibraryItem(Long userId, Long gameId, String gameName) {
        this.userId = userId;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getGameId() { return gameId; }
    public void setGameId(Long gameId) { this.gameId = gameId; }

    public String getGameName() { return gameName; }
    public void setGameName(String gameName) { this.gameName = gameName; }
}
