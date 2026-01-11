package com.filemanager.dto;

import jakarta.validation.constraints.NotBlank;

public record EmailVerificationRequest(
        @NotBlank(message = "Verification token is required")
        String token
) {
}
