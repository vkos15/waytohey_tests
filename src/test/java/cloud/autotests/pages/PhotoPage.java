package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PhotoPage {

    @Step("Нажимаем на стрелку вправо")
    public void clickOnRightArrows() {
        $("#winPhotoScrollR").click();

    }

    @Step("Нажимаем на стрелку влево")
    public void clickOnLeftArrows() {
        $("#winPhotoScrollL").click();
    }
}
