package cloud.autotests.testdata;

import cloud.autotests.pages.User;
import com.github.javafaker.Faker;

import static cloud.autotests.config.waytohey.WaytoheyProject.configW2H;

public class TestData {
    static Faker faker = new Faker();
    public static String nameRandom = faker.name().firstName(),
            emailRandom = faker.internet().emailAddress();

    public static User userSuccess = new User(configW2H.user_active_login(), configW2H.user_active_pass());
    public static User userWrongLogin = new User(configW2H.user_wrong_login(), configW2H.user_wrong_pass());


}
