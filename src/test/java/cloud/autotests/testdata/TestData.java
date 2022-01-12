package cloud.autotests.testdata;

import cloud.autotests.models.User;
import com.github.javafaker.Faker;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class TestData {
    static Faker faker = new Faker();
    public static String nameRandom = faker.name().firstName(),
            emailRandom = faker.internet().emailAddress();

    public static User userSuccess = new User(configW2H.user_active_login(), configW2H.user_active_pass());
    public static User userWrongLogin = new User(configW2H.user_wrong_login(), configW2H.user_wrong_pass());
    public static User userForParamTest = new User(configW2H.user_parametrize_test_login(), configW2H.user_parametrize_test_pass());
    public static String userLoginChatWith = configW2H.user_chat_login();

}
