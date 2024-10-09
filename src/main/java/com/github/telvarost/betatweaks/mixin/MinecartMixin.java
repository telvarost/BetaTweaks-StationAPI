package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(MinecartEntity.class)
abstract class MinecartMixin extends Entity implements Inventory
{
    public MinecartMixin(World arg)
    {
        super(arg);
    }

    @ModifyVariable(
            method = "onCollision",
            at = @At(value = "STORE"),
            ordinal = 6
    )
    private double betaTweaks_minecartBoosterCondition(double d6)
    {
        if (Config.config.minecartBoosters)
            return 0;
        else
            return d6;
    }
}
