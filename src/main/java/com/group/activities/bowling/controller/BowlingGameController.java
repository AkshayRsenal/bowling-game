package com.group.activities.bowling.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.repository.FrameRepository;
import com.group.activities.bowling.service.implementation.FrameServiceImplementation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class BowlingGameController {

    private final FrameServiceImplementation frameServiceImplementation;
    private FrameRepository frameRepository;

    @GetMapping("/")
    public String getHome() {
        return "index"; // This will resolve to src/main/resources/templates/index.html
    }

    @GetMapping("/bowling")
    public String getBowlingGame() {
        return "Welcome to the Bowling Game!";
    }

    @GetMapping("/frames")
    public ResponseEntity<List<Frame>> getAllFrames() {
        List<Frame> frames = frameRepository.findAll();
        return ResponseEntity.ok(frames);
    }

    @PostMapping("/set-frame")
    public ResponseEntity<FrameDto> createFrame(@RequestBody FrameDto frameDto) {
        FrameDto frameDtoAfterFrame = frameServiceImplementation.createFrameFromDto(frameDto);
        return ResponseEntity.ok(frameDtoAfterFrame);
    }

}
