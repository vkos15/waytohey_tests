package cloud.autotests.models;

public class User {

    String login;
    String password;
    String name;
    String email;
    String age;
    String dateOfBirth;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String name, String email, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
