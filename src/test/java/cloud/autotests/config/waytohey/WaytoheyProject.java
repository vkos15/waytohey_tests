package cloud.autotests.config.waytohey;

import org.aeonbits.owner.ConfigFactory;

public class WaytoheyProject {

    public static WaytoheyConfig config = ConfigFactory.create(WaytoheyConfig.class, System.getProperties());


}
