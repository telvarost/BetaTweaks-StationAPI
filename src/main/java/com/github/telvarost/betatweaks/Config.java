package com.github.telvarost.betatweaks;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "BetaTweaks")
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

        @ConfigEntry(
                name = "Allow Gaps In Ladders",
                multiplayerSynced = true
        )
        public Boolean allowGapsInLadders = false;

        @ConfigEntry(
                name = "Enter Fluids By South-East Corner",
                multiplayerSynced = true
        )
        public Boolean allowSouthEastRule = false;

        @ConfigEntry(
                name = "Elevator Boats",
                multiplayerSynced = true
        )
        public Boolean elevatorBoats = false;

        @ConfigEntry(name = "Hide Achievement Notifications")
        public Boolean hideAchievementNotifications = false;

        @ConfigEntry(
                name = "Hide Dead Shrubs",
                description = "Reload world for changes to take effect",
                multiplayerSynced = true
        )
        public Boolean hideDeadShrubs = false;

        @ConfigEntry(
                name = "Hide Long Grass",
                description = "Reload world for changes to take effect",
                multiplayerSynced = true
        )
        public Boolean hideLongGrass = false;

        @ConfigEntry(
                name = "Hoe Grass For Seeds",
                multiplayerSynced = true
        )
        public Boolean hoeGrassForSeeds = false;

        @ConfigEntry(
                name = "Milk Squids",
                multiplayerSynced = true
        )
        public Boolean milkSquids = false;

        @ConfigEntry(
                name = "Minecart Boosters",
                multiplayerSynced = true
        )
        public Boolean minecartBoosters = false;

        @ConfigEntry(
                name = "Pigs Drop Brown Mushrooms",
                multiplayerSynced = true
        )
        public Boolean pigsDropBrownMushrooms = false;

        @ConfigEntry(
                name = "Punch Sheep For Wool",
                multiplayerSynced = true
        )
        public Boolean punchSheepForWool = false;

        @ConfigEntry(
                name = "Punch TNT To Ignite",
                multiplayerSynced = true
        )
        public Boolean punchTntToIgnite = false;

        @ConfigEntry(
                name = "Spread Fire Infinitely",
                multiplayerSynced = true
        )
        public Boolean infiniteFireSpread = false;

        @ConfigEntry(
                name = "Spread Fire Tick Rate",
                description = "Default: 40, Alpha: 10",
                multiplayerSynced = true,
                maxLength =36863
        )
        public Integer fireSpreadTickRate = 40;

        @ConfigEntry(
                name = "Use Player 2x2 Crafting Grid As Inventory",
                multiplayerSynced = true
        )
        public Boolean allowCraftingInventorySlots = false;
    }
}
