package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.block.FireBlock;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;


/*
 * Thanks to Amb0s for the original solution: https://github.com/Amb0s
 */
@Mixin(FireBlock.class)
public class FireMixin extends Block
{
    public FireMixin(int i, int j) {
        super(i, j, Material.FIRE);
        this.setTickRandomly(true);
    }

    @ModifyConstant(method = "getTickRate", constant = @Constant(intValue = 40))
    private int betaTweaks_getTickrate(int a)
    {
        /** - Tick rate is 10 before beta 1.6 */
        return (Config.config.fireSpreadTickRate);
    }


    @Redirect(
            method = "onTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlock(IIIII)Z"
            )
    )
    private boolean betaTweaks_fireTick(@NotNull World level, int x, int y, int z, int id, int meta)
    {
        // Make new fire blocks spawn with zero old:
        if (Config.config.infiniteFireSpread)
        {
            level.setBlock(x, y, z, Block.FIRE.id, 0);
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
