package cloud.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        // "system:properties",
        "classpath:config/waytohey/${environment}.properties"
})

public interface WaytoheyConfig extends Config {

    @DefaultValue("dfg@ml.rootkid.ru")
    @Key("exist_email")
    String existEmail();

    @Key("user_active_login")
    String userActiveLogin();

    @Key("user_active_pass")
    String userActivePass();

    @Key("user_wrong_login")
    String userWrongLogin();

    @Key("user_wrong_pass")
    String userWrongPass();

    @Key("base_url")
    String baseUrl();

    @Key("auth_key_user")
    String authKeyUser();

    @Key("user_parametrize_test_login")
    String userParametrizeTestLogin();

    @Key("user_parametrize_test_pass")
    String userParametrizeTestPass();

    @Key("user_chat_login")
    String userChatLogin();

    @Key("auth_login")
    String authLogin();

    @Key("auth_pass")
    String authPass();

    @Key("user_forever_offline")
    String userForeverOffline();

    @Key("user_forever_offline_time")
    String userForeverOfflineTime();

}
