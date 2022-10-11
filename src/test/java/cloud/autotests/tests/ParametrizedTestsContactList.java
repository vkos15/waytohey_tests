package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MessagePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static cloud.autotests.testdata.TestData.userForParamTest;

@Tag("general")
public class ParametrizedTestsContactList extends TestBase {
    LoginWindow loginPage = new LoginWindow();
    MessagePage messagePage = new MessagePage();


    @ValueSource(strings = {
            "Valentina",
            "ella"
    })

    // @ParameterizedTest(name = "Search {0} in contact list")
    public void testSearchInContactList(String searchString) {
        loginPage.login(userForParamTest.getLogin(), userForParamTest.getPass());
        messagePage.openMessageWindow();
        messagePage.searchContacts(searchString);
        messagePage.checkResultsOfSearch(searchString);
    }

    @CsvSource(value = {
            "Valentina, 1",
            "Ella, 1"
    })
    @ParameterizedTest(name = "Search {0} in contact list")
    public void testSearchAndCheckCountOfUsersInList(String searchString, int count) {
        loginPage.login(userForParamTest.getLogin(), userForParamTest.getPass());
        messagePage.openMessageWindow();
        messagePage.searchContacts(searchString);
        messagePage.checkResultsOfSearch(searchString);
        messagePage.checkCountOfUsers(count);
    }

}


