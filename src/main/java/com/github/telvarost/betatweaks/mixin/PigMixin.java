package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PigEntity.class)
public class PigMixin extends AnimalEntity {
    public PigMixin(World arg) {
        super(arg);
    }

    @Inject(
            method = "getDroppedId",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getMobDrops(CallbackInfoReturnable<Integer> cir) {
        if (Config.config.pigsDropBrownMushrooms) {
            cir.setReturnValue(Block.BROWN_MUSHROOM.id);
        }
    }

}
