package com.example.spring_mockito_demo.service;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring_mockito_demo.entity.User;
import com.example.spring_mockito_demo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setName("Jane Smith");
    }

    @Test
    void testGetUserById_Success() {
        // Given
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.of(testUser));

        // When
        User result = userService.getUserById(userId);

        // Then
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("Jane Smith", result.getName());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testGetUserById_UserNotFound() {
        // Given
        Long userId = 999L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When
        User result = userService.getUserById(userId);

        // Then
        assertNull(result);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testGetUserById_RepositoryException() {
        // Given
        Long userId = 1L;
        when(userRepository.findById(userId)).thenThrow(new RuntimeException("Database connection failed"));

        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(userId);
        });

        assertEquals("Database connection failed", exception.getMessage());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testGetUserById_NullId() {
        // Given
        Long userId = null;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When
        User result = userService.getUserById(userId);

        // Then
        assertNull(result);
        verify(userRepository, times(1)).findById(userId);
    }
}