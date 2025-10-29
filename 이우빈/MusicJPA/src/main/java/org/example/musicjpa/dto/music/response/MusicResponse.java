package org.example.musicjpa.dto.music.response;

import lombok.Builder;
import lombok.Getter;
import org.example.musicjpa.domain.music.Music;

@Getter
@Builder
public class MusicResponse {
    private Long musicId;
    private String musicTitle;
    private Long singerId;
    private String singerName;

    public static MusicResponse musicInfo(Music music) {
        return MusicResponse.builder()
                .musicId(music.getId())
                .musicTitle(music.getTitle())
                .singerId(music.getSinger().getId())
                .singerName(music.getSinger().getName())
                .build();
    }
}
