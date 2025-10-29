package org.example.musicjpa.service.music;

import lombok.RequiredArgsConstructor;
import org.example.musicjpa.domain.music.Music;
import org.example.musicjpa.domain.singer.Singer;
import org.example.musicjpa.dto.music.request.MusicRequest;
import org.example.musicjpa.dto.music.response.MusicResponse;
import org.example.musicjpa.exception.ErrorCode;
import org.example.musicjpa.exception.MusicException;
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
        Singer singer = singerRepository.findById(musicRequest.getSingerId())
                .orElseThrow(() -> new MusicException(ErrorCode.WRONG_SINGER_ID));

        Music music = Music.builder()
                .singer(singer)
                .title(musicRequest.getTitle())
                .build();

        musicRepository.save(music);

        return MusicResponse.musicInfo(music);
    }

    @Transactional(readOnly = true)
    public MusicResponse getMusic(Long musicId) {
        Music music = musicRepository.findById(musicId)
                .orElseThrow(() -> new MusicException(ErrorCode.WRONG_MUSIC_ID));

        return MusicResponse.musicInfo(music);
    }

    @Transactional
    public MusicResponse updateMusic(Long musicId, MusicRequest musicRequest) {
        Music music = musicRepository.findById(musicId)
                .orElseThrow(() -> new MusicException(ErrorCode.WRONG_MUSIC_ID));

        Singer singer = singerRepository.findById(musicRequest.getSingerId())
                .orElseThrow(() -> new MusicException(ErrorCode.WRONG_SINGER_ID));

        music.updateMusic(musicRequest.getTitle(), singer);

        return MusicResponse.musicInfo(music);
    }

    @Transactional
    public void deleteMusic(Long music_id) {
        Music music = musicRepository.findById(music_id)
                .orElseThrow(() -> new MusicException(ErrorCode.WRONG_MUSIC_ID));

        musicRepository.delete(music);
    }

    @Transactional(readOnly = true)
    public List<MusicResponse> getAllMusic() {
        return musicRepository.findAll()
                .stream()
                .map(MusicResponse::musicInfo)
                .toList();
    }
}
