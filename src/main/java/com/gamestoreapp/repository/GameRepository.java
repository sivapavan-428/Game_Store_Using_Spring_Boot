package com.gamestoreapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestoreapp.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findBySectionKey(String sectionKey);
	
	 List<Game> findByGenresContainingIgnoreCase(String genre);
}
