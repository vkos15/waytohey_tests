package cloud.autotests.tests;

import cloud.autotests.pages.Encounters;
import org.junit.jupiter.api.Test;

public class EncountersTests extends TestBase {

    Encounters encountersPage = new Encounters();

    @Test
    void encountersPageUnauthorizedUser() {
        encountersPage.openEncounters()
                .checkContent();
    }
}
