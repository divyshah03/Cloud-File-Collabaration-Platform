package com.filemanager.dto;

public record AuthenticationResponse(
        String token,
        UserDTO user
) {
}
