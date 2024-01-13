package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Minecart;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(Minecart.class)
abstract class MinecartMixin extends EntityBase implements InventoryBase
{
    public MinecartMixin(Level arg)
    {
        super(arg);
    }

    @ModifyVariable(
            method = "method_1353",
            at = @At(value = "STORE"),
            ordinal = 6
    )
    private double d6ConditionDestroyer(double d6)
    {
        if (Config.ConfigFields.minecartBoosters)
            return 0;
        else
            return d6;
    }
}
