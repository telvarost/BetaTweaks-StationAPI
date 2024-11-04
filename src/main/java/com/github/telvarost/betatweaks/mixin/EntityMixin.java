package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(Entity.class)
public class EntityMixin
{
    @Inject(method = "checkWaterCollisions", at = @At("HEAD"), cancellable = true)
    private void betaTweaks_handleWaterMovement(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        if (!Config.config.allowSouthEastRule)
        {
            return;
        }

        // Just remove negative expanding of aabb:
        Entity self = ((Entity) ((Object) this));
        Box aabb = self.boundingBox.expand(0.0, -0.4000000059604645, 0.0);
        boolean res = self.world.updateMovementInFluid(aabb, Material.WATER, self);
        cir.setReturnValue(res);
    }


    @Inject(method = "isTouchingLava", at = @At("HEAD"), cancellable = true)
    private void betaTweaks_handleLavaMovement(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        if (!Config.config.allowSouthEastRule)
        {
            return;
        }

        // Just remove negative expanding of aabb:
        Entity self = ((Entity) ((Object) this));
        Box aabb = self.boundingBox.expand(0.0, -0.4000000059604645, 0.0);
        boolean res = self.world.isMaterialInBox(aabb, Material.LAVA);
        cir.setReturnValue(res);
    }

}
