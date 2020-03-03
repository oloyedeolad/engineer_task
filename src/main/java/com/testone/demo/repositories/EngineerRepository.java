package com.testone.demo.repositories;

import com.testone.demo.models.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    List<Engineer> findAllBySkills_title(String string);
    List<Engineer> findAllBySkills_id (Long id);

}
