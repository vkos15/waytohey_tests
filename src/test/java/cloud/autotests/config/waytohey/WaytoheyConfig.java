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


    String base_url();

//    @Key("environment")
//    String environment();


}
