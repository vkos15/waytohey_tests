package cloud.autotests.config.waytohey;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        // "system:properties",
        "classpath:config/waytohey/${environment}.properties"
})

public interface WaytoheyConfig extends Config {


    String login_correct();


    String password_correct();

    @DefaultValue("dfg@ml.rootkid.ru")
    String exist_email();


    String user_active_login();

    String user_active_pass();

    String user_wrong_login();

    String user_wrong_pass();

    String base_url();

    String auth_key_user();

    String user_parametrize_test_login();

    String user_parametrize_test_pass();

    String user_chat_login();

    String auth_login();

    String auth_pass();


}
