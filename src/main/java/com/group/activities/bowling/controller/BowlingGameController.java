package com.group.activities.bowling.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.repository.FrameRepository;
import com.group.activities.bowling.service.FrameService;

@Controller
public class BowlingGameController {

    // private BowlingGameService bowlingGameService;
    private FrameRepository frameRepository;
    private FrameService frameService;

    @GetMapping("/")
    public String getHome() {
        return "index"; // This will resolve to src/main/resources/templates/index.html
    }

    @GetMapping("/bowling")
    public String getBowlingGame() {
        return "Welcome to the Bowling Game!";
    }

}
