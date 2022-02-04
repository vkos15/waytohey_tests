package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BottomBar {

    SelenideElement search = $(".barbottom a[href$='/search/']");
    SelenideElement encounters = $(".barbottom a[href*='encounters']");


    public void openSearch() {
        search.click();
    }

    public Encounters openEncountersFromBottomBar() {
        encounters.click();
        return new Encounters();
    }

    public void openMenu() {
        $("#menu_icon_title").click();
    }

}
