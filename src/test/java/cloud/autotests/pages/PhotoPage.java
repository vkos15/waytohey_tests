package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PhotoPage {


    @Step("Нажать на стрелку вправо")
    public void clickOnRightArrows() {
        $("#winPhotoScrollR").click();

    }

    @Step("Нажать на стрелку влево")
    public void clickOnLeftArrows() {
        $("#winPhotoScrollL").click();
    }

    @Step("Загрузить фото в профиль, в котором уже есть фото")
    public String uploadMyPhoto(String fileName) {
        $("#addPh").uploadFromClasspath(fileName);
        $("#page_upload .block_save").click();
        sleep(10000);
        String photo_id = $("#visitcard_avatar_block .secondary-photo").getAttribute("data-photoid");
        return photo_id;
    }

    @Step("Проверка количества отображаемых миниатюр фото в профиле")
    public void checkCountPhotoInProfile(int count) {
        $$("#visitcard_avatar_block .secondary-photo").shouldHave(size(count));
    }

    @Step("Удалить фото из профиля на десктопе нажатием на иконку настроек на миниатюре фото")
    public void delMyPhotoFromProfile(String photoID) {
        SelenideElement photo = $("div[data-photoid=" + "'" + photoID + "'] ");
        photo.scrollIntoView("{block: \"center\"}");
        actions().moveToElement(photo).click($("div[data-photoid=" + "'" + photoID + "'] a")).perform();
        $("a.photo-win-delete").shouldHave(text("Delete")).click();
        $("#photoDeletionForm a.block_save").shouldHave(text("Delete")).click();
    }

}
