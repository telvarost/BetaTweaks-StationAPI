package com.github.telvarost.betatweaks;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.GConfig;

public class Config {

    @GConfig(value = "config", visibleName = "BetaTweaks Config")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        /** - These are a part of the InventoryTweaks mod. See: https://github.com/telvarost/InventoryTweaks-StationAPI */
//        @ConfigName("Inventory Dragging Shortcuts")
//        public static Boolean inventoryDraggingShortcuts = true;

        /** - FOV added to the StationAPI version of FinalBeta instead */
//        @ConfigName("FOV Slider")
//        public static Boolean fovSlider = true;

        /** - There are also title screen settings that are missing that the original BetaTweaks had */
        // Dany added some of these to UniTweaks

        @ConfigName("Allow Gaps In Ladders")
        public static Boolean allowGapsInLadders = false;

        @ConfigName("Enter Fluids By South-East Corner")
        public static Boolean allowSouthEastRule = false;

        @ConfigName("Elevator Boats")
        public static Boolean elevatorBoats = false;

        @ConfigName("Hide Achievement Notifications")
        public static Boolean hideAchievementNotifications = false;

        @ConfigName("Hide Dead Shrubs")
        @Comment("Reload world for changes to take effect")
        public static Boolean hideDeadShrubs = false;

        @ConfigName("Hide Long Grass")
        @Comment("Reload world for changes to take effect")
        public static Boolean hideLongGrass = false;

        @ConfigName("Hoe Grass For Seeds")
        public static Boolean hoeGrassForSeeds = false;

        @ConfigName("Minecart Boosters")
        public static Boolean minecartBoosters = false;

        @ConfigName("Punch Sheep For Wool")
        public static Boolean punchSheepForWool = false;

        @ConfigName("Punch TNT To Ignite")
        public static Boolean punchTntToIgnite = false;

//        @ConfigName("Spread Fire Infinitely")
//        public static Boolean infiniteFireSpread = false;
//
//        /** - There is a bug that won't let the config go above 32, also Integer configs don't seem to save unless saved twice */
//        @ConfigName("Spread Fire Tick Rate * 10 (Def: 4, Alpha: 1)")
//        public static Integer fireTickRate = 4;

        @ConfigName("Use Player 2x2 Crafting Grid As Inventory")
        public static Boolean allowCraftingInventorySlots = false;
    }
}
