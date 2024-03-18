package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.tool.Hoe;
import net.minecraft.item.tool.ToolMaterial;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.item.tool.StationHoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Hoe.class)
public class HoeMixin extends ItemBase implements StationHoeItem {
    public HoeMixin(int i, ToolMaterial arg) {
        super(i);
        this.maxStackSize = 1;
        this.setDurability(arg.getDurability());
    }

    @Inject(
            method = "useOnTile",
            at = @At("HEAD"),
            cancellable = true
    )
    public void betaTweaks_useOnTile(ItemInstance arg, PlayerBase arg2, Level arg3, int i, int j, int k, int l, CallbackInfoReturnable<Boolean> cir) {
        if (!Config.config.hoeGrassForSeeds)
        {
            return;
        }

        if (!arg3.isServerSide) {
            int var8 = arg3.getTileId(i, j, k);
            int var9 = arg3.getTileId(i, j + 1, k);
            if ((l == 0 || var9 != 0 || var8 != BlockBase.GRASS.id) && var8 != BlockBase.DIRT.id) {
                /** - Do nothing */
            } else {
                if (var8 == BlockBase.GRASS.id) {
                    Random rand = new Random();
                    int seedsId = this.rand.nextInt(8) == 0 ? ItemBase.seeds.id : -1;
                    if (seedsId != -1) {
                        float f = 0.7F;
                        float f1 = rand.nextFloat() * f + (1.0F - f) * 0.5F;
                        float f2 = 1.2F;
                        float f3 = rand.nextFloat() * f + (1.0F - f) * 0.5F;
                        Item seeds = new Item(arg3, (double) i + f1, (double) j + f2, (double) k + f3, new ItemInstance(seedsId, 1, 0));
                        seeds.pickupDelay = 10;
                        arg3.spawnEntity(seeds);
                    }
                }
            }
        }
    }
}