package org.example.musicjpa.service.music;

import lombok.RequiredArgsConstructor;
import org.example.musicjpa.domain.music.Music;
import org.example.musicjpa.domain.singer.Singer;
import org.example.musicjpa.dto.music.request.MusicRequest;
import org.example.musicjpa.dto.music.response.MusicResponse;
import org.example.musicjpa.repository.music.MusicRepository;
import org.example.musicjpa.repository.singer.SingerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final SingerRepository singerRepository;
    private final MusicRepository musicRepository;

    @Transactional
    public MusicResponse saveMusic(MusicRequest musicRequest) {
        Singer singer = singerRepository.findById(musicRequest.getSinger_id())
                .orElseThrow(() -> new IllegalArgumentException("Singer not found"));

        Music music = Music.builder()
                .singer(singer)
                .title(musicRequest.getTitle())
                .build();

        musicRepository.save(music);

        return MusicResponse.musicInfo(music);
    }

    @Transactional(readOnly = true)
    public MusicResponse getMusic(Long music_id) {
        Music music = musicRepository.findById(music_id)
                .orElseThrow(() -> new IllegalArgumentException("Music not found"));

        return MusicResponse.musicInfo(music);
    }

    @Transactional
    public MusicResponse updateMusic(Long music_id, MusicRequest musicRequest) {
        Music music = musicRepository.findById(music_id)
                .orElseThrow(() -> new IllegalArgumentException("Music not found"));

        Singer singer = singerRepository.findById(musicRequest.getSinger_id())
                .orElseThrow(() -> new IllegalArgumentException("Singer not found"));

        music.updateMusic(musicRequest.getTitle(), singer);

        return MusicResponse.musicInfo(music);
    }

    @Transactional
    public void deleteMusic(Long music_id) {
        Music music = musicRepository.findById(music_id)
                .orElseThrow(() -> new IllegalArgumentException("no music"));
        musicRepository.deleteById(music_id);
    }

    @Transactional(readOnly = true)
    public List<MusicResponse> getAllMusic() {
        return musicRepository.findAll()
                .stream()
                .map(MusicResponse::musicInfo)
                .toList();
    }
}
