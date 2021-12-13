package cloud.autotests.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.waytohey.WaytoheyProject.configW2H;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class UIWithAPIprofileTest extends TestBase {

    @Test
    void deleteAboutMe() {
        open(configW2H.auth_key_user());
        //  Cookie cookies = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrf");
        String cookies = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrf").getValue();

        String cookies2 = WebDriverRunner.getWebDriver().manage().getCookieNamed("MLSID").getValue();

        System.out.println(cookies);
        System.out.println(cookies2);
        given()
                .contentType("application/x-www-form-urlencoded")
                .accept("*/*")
                .cookie("csrf", cookies).and().cookie("MLSID", cookies2)
                // .formParams("orientation","b").relaxedHTTPSValidation()
                .queryParam("action", "save-profile")
                .body("csrf=" + cookies + "&orientation=u")
                .when()
                .post("https://waytohey.com/andry/edit/aboutsex/")
                .then()
                .statusCode(200);
        // .body("total", is(12));

        // https://waytohey.com/andry/edit/aboutsex/?action=window
    }
}
//curl 'https://waytohey.com/andry/edit/aboutsex/?action=save-profile' \
//        -H 'authority: waytohey.com' \
//        -H 'sec-ch-ua: "Google Chrome";v="95", "Chromium";v="95", ";Not A Brand";v="99"' \
//        -H 'accept: text/plain, */*; q=0.01' \
//        -H 'content-type: application/x-www-form-urlencoded; charset=UTF-8' \
//        -H 'x-requested-with: XMLHttpRequest' \
//        -H 'sec-ch-ua-mobile: ?0' \
//        -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \
//        -H 'sec-ch-ua-platform: "Windows"' \
//        -H 'origin: https://waytohey.com' \
//        -H 'sec-fetch-site: same-origin' \
//        -H 'sec-fetch-mode: cors' \
//        -H 'sec-fetch-dest: empty' \
//        -H 'referer: https://waytohey.com/andry' \
//        -H 'accept-language: en-US,en;q=0.9' \
//        -H 'cookie: csrf=38gPG2CXwbOFimm11o78wp1u5FhizByxGD4jvdTPI711IFEpbmnZ7G29o7pf1AWI; MLTZ=GMT%2B0500; __gads=ID=5b60bbfa5a3c560b-228bf8c31dcc006e:T=1638536970:RT=1638536970:S=ALNI_MYQ6jZypM_62Xf5oMx0dyTFBnsWUQ; muid=ad923280-922b-4455-89cf-027e3ba7cf7a; GDPR=all_on-performance_on-functions_on; ML_QA_DEBUG=iMQAEp8j32pr3GKr2679Ainpf6sG7DCS; qa_experiment_suggest_show-w2h-journal=1; qa_experiment_suggest_5rub-card=1; qa_experiment_suggest_5rub-card-popup=1; qa_experiment_suggest_fastclick=1; qa_experiment_suggest_use_new_interests=1; qa_experiment_suggest_redirect_trace=1; skip_photo_suggest2_3630=true; qa_experiment_suggest_seo_search_url=1; qa_experiment_suggest_test_search_stickers=1; qa_experiment_suggest_vip_can_switch_off_with_photos=1; skip_photo_suggest2_3275=true; _gid=GA1.2.5348840.1638767460; MLPUSHSUPPORT=1; ML_PANEL_DEBUG=uS5pcauNxkGQL8KASiJYaJzC5g8BZcX7TfEFUxBx; MLASID=Zc9egaPgWSoSX0O1Jeypm1DPbzMlmRjY; staged-registration-hash=rflsess_Zc9egaPgWSoSX0O1Jeypm1DPbzMlmRjY; MLLGN=48fz1drxzqb64kp3vikw7s9umpy0mwja5iw2syyi6twas337bcaz4qrawru3zuyy; MLSID=LS4pipgbjytAEHUjlLm6y79WWJlEah8y; MLSID-https=true; _wh_vtrkh=1; qa_experiment_suggest_is_tabbed_payment_page=1; qa_experiment_suggest_provider-for-cards=1; skip_photo_suggest2_3973=true; MLTZDBG=Mon%20Dec%2006%202021%2018%3A23%3A50%20GMT%2B0500%20(Yekaterinburg%20Standard%20Time); _ga=GA1.2.698377612.1638536971; _ga_8NNV33YM0K=GS1.1.1638793185.9.1.1638797031.0; MLSCREEN=1920|732|1' \
//        --data-raw 'csrf=38gPG2CXwbOFimm11o78wp1u5FhizByxGD4jvdTPI711IFEpbmnZ7G29o7pf1AWI&orientation=u' \
//        --compressed