package com.example.accountbuilder;

import java.util.Objects;

public final class DefaultAccountBuilder implements AccountBuilder {
    private final PasswordPolicy passwordPolicy;

    private String login;
    private String password;
    private String email;

    public DefaultAccountBuilder() {
        this(new DefaultPasswordPolicy());
    }

    public DefaultAccountBuilder(PasswordPolicy passwordPolicy) {
        this.passwordPolicy = Objects.requireNonNull(passwordPolicy, "passwordPolicy must not be null");
    }

    @Override
    public AccountBuilder login(String login) {
        this.login = login;
        return this;
    }

    @Override
    public AccountBuilder password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public AccountBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public Account build() {

        String normalizedLogin = login == null ? null : login.trim();
        String normalizedEmail = email == null ? null : email.trim();
        String normalizedPassword = password;

        Validator.notBlank(normalizedLogin, "Login");
        passwordPolicy.validate(normalizedPassword);
        Validator.email(normalizedEmail);

        Account account = new Account(normalizedLogin, normalizedPassword, normalizedEmail);

        this.login = null;
        this.password = null;
        this.email = null;

        return account;
    }
}