package com.example.accountbuilder;

public interface AccountBuilder {
    AccountBuilder login(String login);
    AccountBuilder password(String password);
    AccountBuilder email(String email);
    Account build();

}
