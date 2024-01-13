package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Living;
import net.minecraft.level.Level;
import net.minecraft.util.maths.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Living.class, remap = false)
abstract class LivingMixin extends EntityBase
{
    public LivingMixin(Level arg) {
        super(arg);
    }

    @Inject(method = "method_932", at = @At("HEAD"), cancellable = true)
    public void betaTweaks_increaseLadderCoverage(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        if (!Config.ConfigFields.allowGapsInLadders)
        {
            return;
        }

        Living self = ((Living) ((Object) this));
        int x = MathHelper.floor(self.x);
        int yd = MathHelper.floor(self.boundingBox.minY);
        int yu = yd + 1;
        int z = MathHelper.floor(self.z);

        int id1 = self.level.getTileId(x, yd, z);
        int id2 = self.level.getTileId(x, yu, z);

        cir.setReturnValue(id1 == BlockBase.LADDER.id || id2 == BlockBase.LADDER.id);
    }
}
