package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.BlockBase;
import net.minecraft.block.Fire;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;


/*
 * Thanks to Amb0s for the original solution: https://github.com/Amb0s
 */
@Mixin(Fire.class)
public class FireMixin extends BlockBase
{
    public FireMixin(int i, int j) {
        super(i, j, Material.FIRE);
        this.setTicksRandomly(true);
    }

    @ModifyConstant(method = "getTickrate", constant = @Constant(intValue = 40))
    private int betaTweaks_getTickrate(int a)
    {
        // It is 10 in beta before 1.6:
        return (Config.ConfigFields.fireSpreadTickRate * 10);
    }


    @Redirect(
            method = "fireTick",
            at = @At(value = "INVOKE",
            target = "Lnet/minecraft/level/Level;placeBlockWithMetaData(IIIII)Z")
    )
    private boolean betaTweaks_fireTick(@NotNull Level level, int x, int y, int z, int id, int meta)
    {
        // Make new fire blocks spawn with zero old:
        if (Config.ConfigFields.infiniteFireSpread)
        {
            level.placeBlockWithMetaData(x, y, z, BlockBase.FIRE.id, 0);
        }

        return false;
    }

    /** - I couldn't figure out what this was supposed to be targeting */
//    @Redirect(
//            method = "fireTick",
//            at = @At(value = "INVOKE",
//            target = "Lnet/minecraft/src/BlockFire;setBurnResult(Lnet/minecraft/src/World;III)V")
//    )
//    private void cancelSetBurnResult(BlockFire instance, World world, int x, int y, int z)
//    {
//        // Remove a chance to burn a block before the fire block old will reach 15.
//    }
}
