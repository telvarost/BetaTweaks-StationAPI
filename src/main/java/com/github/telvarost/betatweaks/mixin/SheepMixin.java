package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class SheepMixin extends AnimalEntity {

    @Shadow public abstract boolean isSheared();

    @Shadow public abstract void setSheared(boolean bl);

    @Shadow public abstract int getColor();

    public SheepMixin(World arg) {
        super(arg);
        this.texture = "/mob/sheep.png";
        this.setBoundingBoxSpacing(0.9F, 1.3F);
    }

    @Inject(
            method = "damage",
            at = @At("HEAD"),
            cancellable = true
    )
    public void betaTweaks_damage(Entity arg, int i, CallbackInfoReturnable<Boolean> cir) {
        if (!Config.config.punchSheepForWool)
        {
            return;
        }

        if (arg != null && arg instanceof PlayerEntity && !this.isSheared()) {
            if (!this.world.isRemote) {
                this.setSheared(true);
                int var3 = 2 + this.random.nextInt(3);

                for (int var4 = 0; var4 < var3; ++var4) {
                    ItemEntity var5 = this.dropItem(new ItemStack(Block.WOOL.id, 1, this.getColor()), 1.0F);
                    var5.velocityY += (double) (this.random.nextFloat() * 0.05F);
                    var5.velocityX += (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F);
                    var5.velocityZ += (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F);
                }
            }
        }
    }
}
