
public class Main {
    public static void main(String[] args) {
        AccountDirector director = new AccountDirector();

        Account standard = director.standardUser(new DefaultAccountBuilder());
        Account admin    = director.admin(new DefaultAccountBuilder());

        String customPassword = Secrets.fromEnvOrPrompt(
                "CUSTOM_USER_PASSWORD",
                "Enter password for 'erbolatovdamir'"
        );
        Account custom = director.custom(
                new DefaultAccountBuilder(),
                "erbolatovdamir",
                customPassword,
                "erbolatovdamir@mail.kz"
        );

        String securePassword = Secrets.fromEnvOrPrompt(
                "SECURE_USER_PASSWORD",
                "Enter strong password for 'erbolatovdamir'"
        );


        System.out.println(standard);
        System.out.println(admin);
        System.out.println(custom);
    }
}
