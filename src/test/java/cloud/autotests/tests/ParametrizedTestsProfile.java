package cloud.autotests.tests;

import cloud.autotests.enums.Interests;
import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MessagePage;
import cloud.autotests.pages.ProfilePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static cloud.autotests.testdata.TestData.userForParamTest;


public class ParametrizedTestsProfile extends TestBase {
    LoginWindow loginPage = new LoginWindow();

    ProfilePage profilePage = new ProfilePage();



    @EnumSource(Interests.class)
    @ParameterizedTest(name = "Add interest {0} in profile")
    public void testAddInterest(Interests interest) {
        loginPage.login(userForParamTest.getLogin(), userForParamTest.getPass());
        profilePage.selectInterest(interest)
                .checkThatInterestAdd(interest);
    }


    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Working", "Hello", Interests.FAMILY
                ),
                Arguments.of(
                        "Traveling", "I'm a good boy", Interests.YOGA
                )
        );
    }


    @MethodSource("testWithMethodSource")
    @ParameterizedTest(name = "Fill profile status: {0}, aboutMe: {1}, interest: {2}")
    void testChangeProfileInformation(String status, String aboutMe, Interests interest) {
        loginPage.login(userForParamTest.getLogin(), userForParamTest.getPass());
        profilePage.changeStatus(status)
                .checkStatus(status);
        profilePage.changeAboutMe(aboutMe)
                .checkAboutMe(aboutMe);
        profilePage.selectInterest(interest)
                .checkThatInterestAdd(interest);
    }
}


