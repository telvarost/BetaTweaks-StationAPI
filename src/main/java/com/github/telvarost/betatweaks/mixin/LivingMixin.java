package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(LivingEntity.class)
abstract class LivingMixin extends Entity
{
    public LivingMixin(World arg) {
        super(arg);
    }

    @Inject(method = "isOnLadder", at = @At("HEAD"), cancellable = true)
    public void betaTweaks_increaseLadderCoverage(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        if (!Config.config.allowGapsInLadders)
        {
            return;
        }

        LivingEntity self = ((LivingEntity) ((Object) this));
        int x = MathHelper.floor(self.x);
        int yd = MathHelper.floor(self.boundingBox.minY);
        int yu = yd + 1;
        int z = MathHelper.floor(self.z);

        int id1 = self.world.getBlockId(x, yd, z);
        int id2 = self.world.getBlockId(x, yu, z);

        cir.setReturnValue(id1 == Block.LADDER.id || id2 == Block.LADDER.id);
    }
}
