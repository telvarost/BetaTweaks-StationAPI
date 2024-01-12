package com.github.telvarost.betatweaks;

import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.GConfig;

public class Config {

    @GConfig(value = "config", visibleName = "BetaTweaks Config")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

         @ConfigName("Boat Fixes Enabled")
         public static Boolean boatFixesEnabled = true;
    }
}
