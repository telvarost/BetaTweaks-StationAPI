package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(HoeItem.class)
public class HoeMixin extends Item {
    public HoeMixin(int i, ToolMaterial arg) {
        super(i);
        this.maxCount = 1;
        this.setMaxDamage(arg.getDurability());
    }

    @Inject(
            method = "useOnBlock",
            at = @At("HEAD"),
            cancellable = true
    )
    public void betaTweaks_useOnTile(ItemStack arg, PlayerEntity arg2, World arg3, int i, int j, int k, int l, CallbackInfoReturnable<Boolean> cir) {
        if (!Config.config.hoeGrassForSeeds)
        {
            return;
        }

        if (!arg3.isRemote) {
            int var8 = arg3.getBlockId(i, j, k);
            int var9 = arg3.getBlockId(i, j + 1, k);
            if ((l == 0 || var9 != 0 || var8 != Block.GRASS_BLOCK.id) && var8 != Block.DIRT.id) {
                /** - Do nothing */
            } else {
                if (var8 == Block.GRASS_BLOCK.id) {
                    Random rand = new Random();
                    int seedsId = this.random.nextInt(8) == 0 ? Item.SEEDS.id : -1;
                    if (seedsId != -1) {
                        float f = 0.7F;
                        float f1 = rand.nextFloat() * f + (1.0F - f) * 0.5F;
                        float f2 = 1.2F;
                        float f3 = rand.nextFloat() * f + (1.0F - f) * 0.5F;
                        ItemEntity seeds = new ItemEntity(arg3, (double) i + f1, (double) j + f2, (double) k + f3, new ItemStack(seedsId, 1, 0));
                        seeds.pickupDelay = 10;
                        arg3.spawnEntity(seeds);
                    }
                }
            }
        }
    }
}