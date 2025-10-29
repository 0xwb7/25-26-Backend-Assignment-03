package org.example.musicjpa.dto.music.response;

import lombok.Builder;
import lombok.Getter;
import org.example.musicjpa.domain.music.Music;

@Getter
@Builder
public class MusicResponse {
    private Long music_id;
    private String music_title;
    private Long singer_id;
    private String singer_name;

    public static MusicResponse musicInfo(Music music) {
        return MusicResponse.builder()
                .music_id(music.getId())
                .music_title(music.getTitle())
                .singer_id(music.getSinger().getId())
                .singer_name(music.getSinger().getName())
                .build();
    }
}
