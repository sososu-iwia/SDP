package com.example.accountbuilder;

public class AccountDirector {

    public Account standardUser(AccountBuilder builder) {
        return builder
                .login("user123")
                .password("qwerty1")
                .email("user123@example.com")
                .build();
    }

    public Account admin(AccountBuilder builder) {
        return builder
                .login("admin")
                .password("Admin2025")
                .email("admin@company.com")
                .build();
    }

    public Account custom(AccountBuilder builder, String login, String password, String email) {
        return builder
                .login(login)
                .password(password)
                .email(email)
                .build();
    }
}