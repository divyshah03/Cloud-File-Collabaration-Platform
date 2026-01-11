package com.filemanager.services;

public interface EmailServiceInterface {
    void sendVerificationEmail(String toEmail, String userName, String token);
}
