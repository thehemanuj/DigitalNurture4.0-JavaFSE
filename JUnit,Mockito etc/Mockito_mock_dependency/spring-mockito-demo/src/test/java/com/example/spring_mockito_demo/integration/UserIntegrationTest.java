package com.example.spring_mockito_demo.integration;

import com.example.spring_mockito_demo.entity.User;
import com.example.spring_mockito_demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureTestMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureTestMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setName("Integration Test User");
    }

    @Test
    void testGetUserEndpoint_Success() throws Exception {
        // Given
        Long userId = 1L;
        when(userService.getUserById(userId)).thenReturn(testUser);

        // When & Then
        mockMvc.perform(get("/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value("Integration Test User"));

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUserEndpoint_UserNotFound() throws Exception {
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
    void testGetUserEndpoint_ServiceThrowsException() throws Exception {
        // Given
        Long userId = 1L;
        when(userService.getUserById(userId)).thenThrow(new RuntimeException("Service unavailable"));

        // When & Then
        mockMvc.perform(get("/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUserEndpoint_InvalidPathVariable() throws Exception {
        // When & Then
        mockMvc.perform(get("/users/invalid")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(userService, never()).getUserById(anyLong());
    }

    @Test
    void testApplicationContextLoads() {
        // This test ensures that the Spring context loads successfully
        // with all the mocked beans in place
        assertNotNull(mockMvc);
        assertNotNull(userService);
        assertNotNull(objectMapper);
    }

    private void assertNotNull(Object object) {
        if (object == null) {
            throw new AssertionError("Object should not be null");
        }
    }
}