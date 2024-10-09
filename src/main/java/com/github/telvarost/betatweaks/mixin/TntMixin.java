package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.block.TntBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TntBlock.class)
public class TntMixin extends Block {

    public TntMixin(int i, int j) {
        super(i, j, Material.TNT);
    }

    @Redirect(
            method = "onBlockBreakStart",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;getHand()Lnet/minecraft/item/ItemStack;"
            )
    )
    public ItemStack betaTweaks_getHeldItem(PlayerEntity instance) {
        if (Config.config.punchTntToIgnite)
        {
            return new ItemStack(Item.FLINT_AND_STEEL, 1);
        }
        else
        {
            return instance.getHand();
        }
    }
}

