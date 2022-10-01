package org.anytest.utils.config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {
    private  ConfigFactory(){

    }
    public static ConfigReader getConfig(){
        return ConfigCache.getOrCreate(ConfigReader.class);
    }
}
