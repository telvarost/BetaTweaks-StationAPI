package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.Boat;
import net.minecraft.entity.EntityBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(Boat.class)
abstract class BoatMixin extends EntityBase
{
    public BoatMixin(Level level) {
        super(level);
    }

    @ModifyConstant(method = "tick", constant = @Constant(doubleValue = 1.0, ordinal = 1))
    private double betaTweaks_elevatorBoatCondition(double d)
    {
        if (Config.ConfigFields.elevatorBoats)
        {
            return Double.MAX_VALUE;
        }
        else
        {
            return d;
        }
    }
}
