package org.example.musicjpa.dto.singer.response;

import lombok.Builder;
import lombok.Getter;
import org.example.musicjpa.domain.singer.Singer;

@Getter
@Builder
public class SingerResponse {
    private Long singerId;
    private String singerName;
    private int debutYear;

    public static SingerResponse singerInfo(Singer singer) {
        return SingerResponse.builder()
                .singerId(singer.getId())
                .singerName(singer.getName())
                .debutYear(singer.getDebutYear())
                .build();
    }
}
