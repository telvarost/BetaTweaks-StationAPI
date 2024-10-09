package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(BoatEntity.class)
abstract class BoatMixin extends Entity
{
    public BoatMixin(World level) {
        super(level);
    }

    @ModifyConstant(method = "tick", constant = @Constant(doubleValue = 1.0, ordinal = 1))
    private double betaTweaks_elevatorBoatCondition(double d)
    {
        if (Config.config.elevatorBoats)
        {
            return Double.MAX_VALUE;
        }
        else
        {
            return d;
        }
    }
}
