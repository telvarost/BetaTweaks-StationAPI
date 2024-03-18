package com.github.telvarost.betatweaks;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.GConfig;
import net.glasslauncher.mods.api.gcapi.api.MaxLength;
import net.glasslauncher.mods.api.gcapi.api.MultiplayerSynced;

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
        @MultiplayerSynced
        public static Boolean allowGapsInLadders = false;

        @ConfigName("Enter Fluids By South-East Corner")
        @MultiplayerSynced
        public static Boolean allowSouthEastRule = false;

        @ConfigName("Elevator Boats")
        @MultiplayerSynced
        public static Boolean elevatorBoats = false;

        @ConfigName("Hide Achievement Notifications")
        @MultiplayerSynced
        public static Boolean hideAchievementNotifications = false;

        @ConfigName("Hide Dead Shrubs")
        @Comment("Reload world for changes to take effect")
        @MultiplayerSynced
        public static Boolean hideDeadShrubs = false;

        @ConfigName("Hide Long Grass")
        @Comment("Reload world for changes to take effect")
        @MultiplayerSynced
        public static Boolean hideLongGrass = false;

        @ConfigName("Hoe Grass For Seeds")
        @MultiplayerSynced
        public static Boolean hoeGrassForSeeds = false;

        @ConfigName("Minecart Boosters")
        @MultiplayerSynced
        public static Boolean minecartBoosters = false;

        @ConfigName("Punch Sheep For Wool")
        @MultiplayerSynced
        public static Boolean punchSheepForWool = false;

        @ConfigName("Punch TNT To Ignite")
        @MultiplayerSynced
        public static Boolean punchTntToIgnite = false;

        @ConfigName("Spread Fire Infinitely")
        @MultiplayerSynced
        public static Boolean infiniteFireSpread = false;

        @ConfigName("Spread Fire Tick Rate (Def: 40, Alpha: 10)")
        @MaxLength(36863)
        @MultiplayerSynced
        public static Integer fireSpreadTickRate = 40;

        @ConfigName("Use Player 2x2 Crafting Grid As Inventory")
        @MultiplayerSynced
        public static Boolean allowCraftingInventorySlots = false;
    }
}
