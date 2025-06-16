package com.group.activities.bowling.integration.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.group.activities.bowling.controller.BowlingGameController;
import com.group.activities.bowling.service.BowlingGameService;

@WebMvcTest(BowlingGameController.class)
@DisplayName("When get mapping BowlingGameController")
public class BowlingGameController_IT_Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BowlingGameService bowlingGameService;

    // Initial Test method
    @Test
    void contextLoads() {
        // This is a placeholder for the integration test.
        // Actual test logic will be implemented later.
    }

    @Test
    @DisplayName("should return a valid response")
    public void forValidGet_shouldReturn200_True() throws Exception {

        mockMvc.perform(get("/")) // Perform a GET request to the root URL
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("<h1>Welcome to the Bowling Application!</h1>")));

    }
}
