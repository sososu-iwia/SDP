package com.example.accountbuilder;

public interface PasswordPolicy {
    void validate(String rawPassword);
}