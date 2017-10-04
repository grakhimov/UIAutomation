package Constants;

public enum UserData {

    USER(
            "epam",
            "1234",
            "PITER CHAILOVSKII"
    );

    public String login;
    public String password;
    public String username;

    UserData(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }
}
