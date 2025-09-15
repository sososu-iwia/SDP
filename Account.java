import java.util.Objects;

public final class Account {
    private final String login;
    private final String password;
    private final String email;

    Account(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='***REDACTED***'" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(login, account.login) &&
                Objects.equals(password, account.password) &&
                Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, email);
    }
}
