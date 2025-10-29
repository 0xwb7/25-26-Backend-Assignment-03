package org.example.musicjpa.domain.music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musicjpa.domain.singer.Singer;

@Entity
@Getter
@NoArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "singer_id")
    private Singer singer;

    @Builder
    public Music(String title, Singer singer) {
        this.title = title;
        this.singer = singer;
    }

    public void updateMusic(String title, Singer singer) {
        this.title = title;
        this.singer = singer;
    }
}
