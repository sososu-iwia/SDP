

import java.util.regex.Pattern;

public final class Validator {
    private static final Pattern SIMPLE_EMAIL =
            Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");

    private Validator() {}

    public static void notBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be blank.");
        }
    }

    public static void email(String email) {
        notBlank(email, "Email");
        if (!SIMPLE_EMAIL.matcher(email).matches()) {
            throw new IllegalArgumentException("Email format is invalid.");
        }
    }
}
