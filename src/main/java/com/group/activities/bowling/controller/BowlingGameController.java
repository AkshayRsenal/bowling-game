package com.group.activities.bowling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.group.activities.bowling.service.BowlingGameService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
public class BowlingGameController {

    // private BowlingGameService bowlingGameService;

    @GetMapping("/")
    public String getHome() {
        return "index"; // This will resolve to src/main/resources/templates/index.html
    }

    @GetMapping("/bowling")
    public String getBowlingGame() {
        return "Welcome to the Bowling Game!";
    }

}
