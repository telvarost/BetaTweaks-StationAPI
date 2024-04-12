package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Pig;
import net.minecraft.item.ItemBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Pig.class)
public class PigMixin extends AnimalBase {
    public PigMixin(Level arg) {
        super(arg);
    }

    @Inject(
            method = "getMobDrops",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getMobDrops(CallbackInfoReturnable<Integer> cir) {
        if (Config.config.pigsDropBrownMushrooms) {
            cir.setReturnValue(BlockBase.BROWN_MUSHROOM.id);
        }
    }

}
