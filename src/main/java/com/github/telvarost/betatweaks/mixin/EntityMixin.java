package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.util.maths.Box;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(EntityBase.class)
public class EntityMixin
{
    @Inject(method = "method_1393", at = @At("HEAD"), cancellable = true)
    private void betaTweaks_handleWaterMovement(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        if (!Config.ConfigFields.allowSouthEastRule)
        {
            return;
        }

        // Just remove negative expanding of aabb:
        EntityBase self = ((EntityBase) ((Object) this));
        Box aabb = self.boundingBox.expand(0.0, -0.4000000059604645, 0.0);
        boolean res = self.level.method_170(aabb, Material.WATER, self);
        cir.setReturnValue(res);
    }


    @Inject(method = "method_1335", at = @At("HEAD"), cancellable = true)
    private void betaTweaks_handleLavaMovement(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        if (!Config.ConfigFields.allowSouthEastRule)
        {
            return;
        }

        // Just remove negative expanding of aabb:
        EntityBase self = ((EntityBase) ((Object) this));
        Box aabb = self.boundingBox.expand(0.0, -0.4000000059604645, 0.0);
        boolean res = self.level.method_169(aabb, Material.LAVA);
        cir.setReturnValue(res);
    }

}
