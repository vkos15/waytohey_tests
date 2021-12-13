package cloud.autotests.config.waytohey;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        // "system:properties",
        "classpath:config/waytohey/${environment}.properties"
})

public interface WaytoheyConfig extends Config {

    @DefaultValue("valentina71551")
    String login_correct();

    @DefaultValue("r347b7")
    String password_correct();

    @DefaultValue("dfg@ml.rootkid.ru")
    String exist_email();


    String user_active_login();

    String user_active_pass();

    String user_wrong_login();

    String user_wrong_pass();

    String base_url();

    String auth_key_user();


}
