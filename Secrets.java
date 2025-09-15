import java.io.Console;
import java.util.Scanner;

public final class Secrets {
    private Secrets() {}


    public static String fromEnvOrPrompt(String envVar, String promptLabel) {
        String env = System.getenv(envVar);
        if (env != null && !env.isBlank()) {
            return env;
        }
        return promptMasked(promptLabel);
    }


    public static String promptMasked(String promptLabel) {
        Console console = System.console();
        if (console != null) {
            char[] chars = console.readPassword("%s: ", promptLabel);
            return chars == null ? "" : new String(chars);
        }

        System.out.print(promptLabel + ": ");
        return new Scanner(System.in).nextLine();
    }
}
