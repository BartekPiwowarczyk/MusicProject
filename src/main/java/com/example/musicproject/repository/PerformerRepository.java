package com.example.musicproject.repository;

import com.example.musicproject.model.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerformerRepository extends JpaRepository<Performer,Long> {
    @Query("SELECT p FROM Performer p WHERE p.name = :name")
    Optional<Performer> findByName(@Param("name") String name);
}
