# BetaTweaks StationAPI Edition for Minecraft Beta 1.7.3

**If you're looking for the ModLoader edition, see this repository:** https://github.com/rekadoodle/BetaTweaks

**Special thanks to EOfSL and Amb0s for their similar BTA mod:** https://github.com/EOfSL/bta-old-nostalgic-bugs

**If you're looking for skin fixes and inventory fixes:** https://modrinth.com/mod/mojangfix/versions

## Mod Info:

All fixes are disabled by default. You will need ModMenu and GlassConfigAPI to enable them. See installation instructions below.

### Implemented
* Allow player crafting grid (2x2 grid) to be used as inventory slots.
* Allow Gaps In Ladders
* Elevator Boats
* Hide Achievement Notifications
* Hoe Grass For Seeds
* Minecart Boosters
* Punch Sheep For Wool
* Punch TNT To Ignite
* [Water ladders](https://minecraft.fandom.com/wiki/Tutorials/Water_ladder): entities can get into fluids through the south-east corner or into some sides via signs/ladders

### Optional
Use version 1.2.1 to EXCLUDE this tweak.
Use version 1.2.0-fire to INCLUDE this tweak.
* Infinite Fire Spread And Selectable Tick Rate
  * WARNING: Please be careful with this setting, always make sure it is false when editing configs unless if you really want it true
  * Note: There currently seems to be a bug with GlassConfigAPI where Integer configs need to be saved twice to take effect

### Not Implemented
* Inventory Dragging Shortcuts (See: https://github.com/telvarost/InventoryTweaks-StationAPI)
* FOV Slider
* Disable Long Grass
* Disable Dead Shrubs

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/babric/prism-instance
2. Install Java 17, set the instance to use it, and disable compatibility checks on the instance: https://adoptium.net/temurin/releases/
3. Add StationAPI to the mod folder for the instance: https://jenkins.glass-launcher.net/job/StationAPI/lastSuccessfulBuild/
4. (Required) Add Mod Menu to the mod folder for the instance: https://github.com/calmilamsy/ModMenu/releases
5. (Required) Add GlassConfigAPI 1.1.6+ to the mod folder for the instance: https://maven.glass-launcher.net/#/releases/net/glasslauncher/mods/GlassConfigAPI
6. Add this mod to the mod folder for the instance: https://github.com/telvarost/BetaTweaks-StationAPI/releases
7. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/BetaTweaks-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
