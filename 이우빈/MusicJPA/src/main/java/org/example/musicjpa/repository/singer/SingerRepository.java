package org.example.musicjpa.repository.singer;

import org.example.musicjpa.domain.singer.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}
