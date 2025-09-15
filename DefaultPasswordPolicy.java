
public class DefaultPasswordPolicy implements PasswordPolicy {
    private static final int MIN_LENGTH = 6;

    @Override
    public void validate(String rawPassword) {
        Validator.notBlank(rawPassword, "Password");
        if (rawPassword.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("Password must be at least " + MIN_LENGTH + " characters.");
        }
        if (!rawPassword.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }
    }
}
