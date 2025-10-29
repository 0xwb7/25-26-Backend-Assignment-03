package org.example.musicjpa.repository.music;

import org.example.musicjpa.domain.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
