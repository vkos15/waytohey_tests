package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GalleryPage {


    @Step("Открыть окно размещения в галерее")
    public GalleryPage openGallery() {
        $("#pb_gallery").click();
        return this;
    }

    @Step("Открыть окно размещения в галерее")
    public GalleryPage checkHeader() {
        $("#pay_gallery_window").shouldHave(text("Get featured now"));
        return this;
    }


}
