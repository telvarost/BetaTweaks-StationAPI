package com.github.telvarost.betatweaks;

import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.GConfig;

public class Config {

    @GConfig(value = "config", visibleName = "BetaTweaks Config")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

//        @ConfigName("Inventory Dragging Shortcuts")
//        public static Boolean inventoryDraggingShortcuts = true;

        /** - There are also title screen settings but that along with FOV I don't think I'll implement */
//        @ConfigName("FOV Slider")
//        public static Boolean fovSlider = true;

        @ConfigName("Hide Achievement Notifications")
        public static Boolean hideAchievementNotifications = true;

//        @ConfigName("Disable Long Grass")
//        public static Boolean disableLongGrass = true;
//
//        @ConfigName("Disable Dead Shrubs")
//        public static Boolean disableDeadShrubs = true;

        @ConfigName("Punch Sheep For Wool")
        public static Boolean punchSheepForWool = true;

//        @ConfigName("Allow Gaps In Ladders")
//        public static Boolean allowGapsInLadders = true;

        @ConfigName("Punch TNT To Ignite")
        public static Boolean punchTntToIgnite = true;

        @ConfigName("Hoe Grass For Seeds")
        public static Boolean hoeGrassForSeeds = true;

//        @ConfigName("Minecart Boosters")
//        public static Boolean minecartBoosters = true;
//
//        @ConfigName("Elevator Boats")
//        public static Boolean elevatorBoats = true;
    }
}
