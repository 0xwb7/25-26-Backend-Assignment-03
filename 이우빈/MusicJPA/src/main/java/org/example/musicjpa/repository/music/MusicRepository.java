package org.example.musicjpa.repository.music;

import org.example.musicjpa.domain.music.Music;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    @Override
    @EntityGraph(attributePaths = "singer")
    List<Music> findAll();
}
