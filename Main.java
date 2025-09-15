public class Main {
    public static void main(String[] args) {
        Account account = Account.initializeRegistrar().login("user123").password("qwerty").email("user@mail.com").createAccount();
    }
}