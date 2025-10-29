package org.example.musicjpa.service.singer;

import lombok.RequiredArgsConstructor;
import org.example.musicjpa.domain.singer.Singer;
import org.example.musicjpa.dto.singer.request.SingerRequest;
import org.example.musicjpa.dto.singer.response.SingerResponse;
import org.example.musicjpa.exception.ErrorCode;
import org.example.musicjpa.exception.MusicException;
import org.example.musicjpa.repository.singer.SingerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SingerService {

    private final SingerRepository singerRepository;

    @Transactional
    public SingerResponse saveSinger(SingerRequest singerRequest) {
        Singer singer = Singer.builder()
                .name(singerRequest.getName())
                .debutYear(singerRequest.getDebutYear())
                .build();

        singerRepository.save(singer);

        return SingerResponse.singerInfo(singer);
    }

    @Transactional
    public void deleteSinger(Long singerId) {
        Singer singer = singerRepository.findById(singerId)
                .orElseThrow(() -> new MusicException(ErrorCode.WRONG_SINGER_ID));

        singerRepository.delete(singer);
    }
}
