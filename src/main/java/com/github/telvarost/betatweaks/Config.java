package com.github.telvarost.betatweaks;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.*;

public class Config {

    @GConfig(value = "config", visibleName = "BetaTweaks")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        /** - These are a part of the InventoryTweaks mod. See: https://github.com/telvarost/InventoryTweaks-StationAPI */
//        @ConfigName("Inventory Dragging Shortcuts")
//        public Boolean inventoryDraggingShortcuts = true;

        /** - FOV added to the StationAPI version of FinalBeta instead */
//        @ConfigName("FOV Slider")
//        public Boolean fovSlider = true;

        /** - There are also title screen settings that are missing that the original BetaTweaks had */
        // Dany added some of these to UniTweaks

        @ConfigName("Allow Gaps In Ladders")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean allowGapsInLadders = false;

        @ConfigName("Enter Fluids By South-East Corner")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean allowSouthEastRule = false;

        @ConfigName("Elevator Boats")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean elevatorBoats = false;

        @ConfigName("Hide Achievement Notifications")
        public Boolean hideAchievementNotifications = false;

        @ConfigName("Hide Dead Shrubs")
        @Comment("Reload world for changes to take effect")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean hideDeadShrubs = false;

        @ConfigName("Hide Long Grass")
        @Comment("Reload world for changes to take effect")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean hideLongGrass = false;

        @ConfigName("Hoe Grass For Seeds")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean hoeGrassForSeeds = false;

        @ConfigName("Minecart Boosters")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean minecartBoosters = false;

        @ConfigName("Pigs Drop Brown Mushrooms")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean pigsDropBrownMushrooms = false;

        @ConfigName("Punch Sheep For Wool")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean punchSheepForWool = false;

        @ConfigName("Punch TNT To Ignite")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean punchTntToIgnite = false;

        @ConfigName("Spread Fire Infinitely")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean infiniteFireSpread = false;

        @ConfigName("Spread Fire Tick Rate")
        @Comment("Default: 40, Alpha: 10")
        @MaxLength(36863)
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Integer fireSpreadTickRate = 40;

        @ConfigName("Use Player 2x2 Crafting Grid As Inventory")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean allowCraftingInventorySlots = false;
    }
}
