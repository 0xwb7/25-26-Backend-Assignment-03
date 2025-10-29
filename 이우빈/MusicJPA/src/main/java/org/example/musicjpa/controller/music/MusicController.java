package org.example.musicjpa.controller.music;

import lombok.RequiredArgsConstructor;
import org.example.musicjpa.dto.music.request.MusicRequest;
import org.example.musicjpa.dto.music.response.MusicResponse;
import org.example.musicjpa.service.music.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    @PostMapping
    public ResponseEntity<MusicResponse> saveMusic(@RequestBody MusicRequest musicRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicService.saveMusic(musicRequest));
    }

    @GetMapping("/{musicId}")
    public ResponseEntity<MusicResponse> getMusic(@PathVariable Long musicId) {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.getMusic(musicId));
    }

    @PatchMapping("/{musicId}")
    public ResponseEntity<MusicResponse> updateMusic(@PathVariable Long musicId, @RequestBody MusicRequest musicRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.updateMusic(musicId, musicRequest));
    }

    @DeleteMapping("/{musicId}")
    public ResponseEntity<MusicResponse> deleteMusic(@PathVariable Long musicId) {
        musicService.deleteMusic(musicId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<MusicResponse>> getAllMusic() {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.getAllMusic());
    }
}
