package org.example.musicjpa.dto.singer.response;

import lombok.Builder;
import lombok.Getter;
import org.example.musicjpa.domain.singer.Singer;

@Getter
@Builder
public class SingerResponse {
    private Long singer_id;
    private String singer_name;
    private int debut_year;

    public static SingerResponse singerInfo(Singer singer) {
        return SingerResponse.builder()
                .singer_id(singer.getId())
                .singer_name(singer.getName())
                .debut_year(singer.getDebutyear())
                .build();
    }
}
