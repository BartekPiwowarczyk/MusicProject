package com.example.musicproject.repository;

import com.example.musicproject.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    Optional<Album> findByTitle(String element);
}
