package com.example.spring_mockito_demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.spring_mockito_demo.entity.User;
import com.example.spring_mockito_demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetUser_Success() throws Exception {
        // Given
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("John Doe");

        when(userService.getUserById(userId)).thenReturn(mockUser);

        // When & Then
        mockMvc.perform(get("/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUser_UserNotFound() throws Exception {
        // Given
        Long userId = 999L;
        when(userService.getUserById(userId)).thenReturn(null);

        // When & Then
        mockMvc.perform(get("/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUser_ServiceException() throws Exception {
        // Given
        Long userId = 1L;
        when(userService.getUserById(userId)).thenThrow(new RuntimeException("Database error"));

        // When & Then
        mockMvc.perform(get("/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());

        verify(userService, times(1)).getUserById(userId);
    }
}