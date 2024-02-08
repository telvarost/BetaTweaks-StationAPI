package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.DeadBush;
import net.minecraft.block.Plant;
import net.minecraft.level.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(DeadBush.class)
public class DeadBushMixin extends Plant {
    public DeadBushMixin(int i, int j) {
        super(i, j);
    }

    @Inject(
            method = "getDropId",
            at = @At("HEAD"),
            cancellable = true
    )
    public void getDropId(int i, Random random, CallbackInfoReturnable<Integer> cir) {
        if (Config.ConfigFields.hideDeadShrubs) {
            cir.setReturnValue(-1);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSideRendered(BlockView arg, int i, int j, int k, int l) {
        return false;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        if (Config.ConfigFields.hideLongGrass) {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public void updateBoundingBox(BlockView blockView, int x, int y, int z) {
        if (Config.ConfigFields.hideDeadShrubs) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        else {
            float var3 = 0.4F;
            this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
        }
    }
}
