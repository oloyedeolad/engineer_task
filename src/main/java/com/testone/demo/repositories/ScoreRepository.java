package com.testone.demo.repositories;

import com.testone.demo.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByEngineer_Id(Long along);

    @Query("SELECT s FROM Score s WHERE skill_id = ?2 ORDER BY score DESC ")
    List<Score> findTopNByScore (int N,  Long skillId);

}
