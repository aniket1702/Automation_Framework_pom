package org.anytest.utils.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "system:env", "file:${user.dir}/src/main/resources/config/config.properties" })
public interface ConfigReader extends Config {
    @Key("baseURL")
    String baseURL();

    @Key("browser")
    String browser();

    @Key("runMode")
    String runMode();

    @Key("environment")
    String environment();

    @Key("websiteName")
    String websiteName();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("overrideReport")
    String overrideReport();

}
