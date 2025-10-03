package com.group.activities.bowling.integration.controller;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.group.activities.bowling.controller.BowlingGameController;
import com.group.activities.bowling.service.BowlingGameService;

//Todo: Write integration tests for BowlingGameController
// @WebMvcTest(BowlingGameController.class)
// @AutoConfigureMockMvc
// @DisplayName("When get mapping BowlingGameController")
public class BowlingGameController_IT_Test {

    // @Autowired
    // private MockMvc mockMvc;

    // @MockitoBean
    // private BowlingGameService bowlingGameService;

    // @Test
    // @DisplayName("should return a valid response")
    // public void forValidGet_shouldReturn200_True() throws Exception {

    // // Given
    // given(bowlingGameService.getCurrentScore())
    // .willReturn(0); // Assuming the service returns 0 for a new game

    // mockMvc.perform(get("/")) // Perform a GET request to the root URL
    // .andExpect(status().isOk())
    // .andDo(print());
    // // .andExpect(view().name("index"))
    // // .andExpect(content().contentType("text/html;charset=UTF-8"))
    // // .andExpect(content().string(containsString("<h1>Welcome to the Bowling
    // Application!</h1>")));

    // }

    @Test
    public void forValidId_shouldReturn200_True() throws Exception {
    }
}
