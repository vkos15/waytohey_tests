package cloud.autotests.testdata;

import cloud.autotests.models.User;
import com.github.javafaker.Faker;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class TestData {
    static Faker faker = new Faker();
    public static String nameRandom = faker.name().firstName(),
            emailRandom = faker.internet().emailAddress();

    public static User userSuccess = new User(configW2H.userActiveLogin(), configW2H.userActivePass());
    public static User userWrongLogin = new User(configW2H.userWrongLogin(), configW2H.userWrongPass());
    public static User userForParamTest = new User(configW2H.userParametrizeTestLogin(), configW2H.userParametrizeTestPass());
    public static String userLoginChatWith = configW2H.userChatLogin();

}
