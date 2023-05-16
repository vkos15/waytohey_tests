package cloud.autotests.pages;

import cloud.autotests.tests.TestBase;
import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Selenide.$;

public class FeedbackPage extends TestBase {

    @Step("Открываем раздел Помощь")
    public void openHelp() {
        if (isWebMobile()) {
            $("#menu_icon_title").click();
        }
    }
}
