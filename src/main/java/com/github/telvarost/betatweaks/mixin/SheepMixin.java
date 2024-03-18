package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Sheep;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public abstract class SheepMixin extends AnimalBase {

    @Shadow public abstract boolean isSheared();

    @Shadow public abstract void setSheared(boolean bl);

    @Shadow public abstract int getColour();

    public SheepMixin(Level arg) {
        super(arg);
        this.texture = "/mob/sheep.png";
        this.setSize(0.9F, 1.3F);
    }

    @Inject(
            method = "damage",
            at = @At("HEAD"),
            cancellable = true
    )
    public void betaTweaks_damage(EntityBase arg, int i, CallbackInfoReturnable<Boolean> cir) {
        if (!Config.config.punchSheepForWool)
        {
            return;
        }

        if (arg != null && arg instanceof PlayerBase && !this.isSheared()) {
            if (!this.level.isServerSide) {
                this.setSheared(true);
                int var3 = 2 + this.rand.nextInt(3);

                for (int var4 = 0; var4 < var3; ++var4) {
                    Item var5 = this.dropItem(new ItemInstance(BlockBase.WOOL.id, 1, this.getColour()), 1.0F);
                    var5.velocityY += (double) (this.rand.nextFloat() * 0.05F);
                    var5.velocityX += (double) ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
                    var5.velocityZ += (double) ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
                }
            }
        }
    }
}
