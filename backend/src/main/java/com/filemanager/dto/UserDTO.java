package com.filemanager.dto;

import com.filemanager.models.Role;

import java.time.LocalDateTime;

public record UserDTO(
        Long id,
        String name,
        String email,
        Role role,
        Boolean enabled,
        LocalDateTime emailVerifiedAt,
        LocalDateTime createdAt
) {
}
