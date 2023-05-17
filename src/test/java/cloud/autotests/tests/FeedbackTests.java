package cloud.autotests.tests;

import cloud.autotests.pages.FeedbackPage;
import cloud.autotests.pages.LoginWindow;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.textMessageRandom;

@Tag("general")
public class FeedbackTests extends TestBase {

    FeedbackPage feedbackPage = new FeedbackPage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    void sendMessageToFeedback() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        feedbackPage.openHelp()
                .chooseCategory("I didn't find the answer")
                .textMessage(textMessageRandom)
                .addImage("img/feedbacktest.jpg")
                .sendMessage();
        feedbackPage.deleteQuestion();

    }


}
