package cloud.autotests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PremiumPage {

    public void openPremium() {
        $(".user-menu-features").$(byText("Premium")).click();
    }

    public void checkOfferToDownloadApp() {
        $("#download_app").shouldHave(text("Ready to become Premium user?"));
    }
}
