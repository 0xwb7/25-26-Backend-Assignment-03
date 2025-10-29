package org.example.musicjpa.domain.singer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musicjpa.domain.music.Music;
import org.example.musicjpa.exception.ErrorCode;
import org.example.musicjpa.exception.MusicException;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String name;

    @Column(name = "debut_year")
    private int debutYear;

    @OneToMany(mappedBy = "singer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Music> musics = new ArrayList<>();

    @Builder
    public Singer(String name, Integer debutYear) {
        validate(name, debutYear);

        this.name = name;
        this.debutYear = debutYear;
    }

    private void validate(String name, Integer debutYear) {
        if (name == null || name.isBlank()) {
            throw new MusicException(ErrorCode.WRONG_NAME_INPUT);
        }

        if (debutYear == null || debutYear <= 0) {
            throw new MusicException(ErrorCode.WRONG_DEBUT_INPUT);
        }
    }
}
