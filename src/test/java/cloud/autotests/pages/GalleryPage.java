package cloud.autotests.pages;

import io.qameta.allure.Step;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GalleryPage {

    BottomBar bottomBar = new BottomBar();

    @Step("Открыть окно размещения в галерее")
    public GalleryPage openGallery() {
        //на м версии галерея доступна например из поиска
        if (isWebMobile())
            bottomBar.openSearch();
        $("#pb_gallery").click();
        return this;
    }

    @Step("Проверка заголовка окна")
    public GalleryPage checkHeader() {
        $("#pay_gallery_window").shouldHave(text("Get featured now"));
        return this;
    }


}
