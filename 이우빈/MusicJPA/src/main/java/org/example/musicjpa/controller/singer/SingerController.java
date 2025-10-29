package org.example.musicjpa.controller.singer;

import lombok.RequiredArgsConstructor;
import org.example.musicjpa.dto.singer.request.SingerRequest;
import org.example.musicjpa.dto.singer.response.SingerResponse;
import org.example.musicjpa.service.singer.SingerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/singer")
public class SingerController {

    private final SingerService singerService;

    @PostMapping
    public ResponseEntity<SingerResponse> saveSinger(@RequestBody SingerRequest singerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(singerService.saveSinger(singerRequest));
    }

    @DeleteMapping("/{singerId}")
    public ResponseEntity<Void> deleteSinger(@PathVariable Long singerId) {
        singerService.deleteSinger(singerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
