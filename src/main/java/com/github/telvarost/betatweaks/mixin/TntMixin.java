package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.block.BlockBase;
import net.minecraft.block.Tnt;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Tnt.class)
public class TntMixin extends BlockBase {

    public TntMixin(int i, int j) {
        super(i, j, Material.TNT);
    }

    @Redirect(
            method = "activate(Lnet/minecraft/level/Level;IIILnet/minecraft/entity/player/PlayerBase;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerBase;getHeldItem()Lnet/minecraft/item/ItemInstance;"
            )
    )
    public ItemInstance betaTweaks_getHeldItem(PlayerBase instance) {
        if (Config.config.punchTntToIgnite)
        {
            return new ItemInstance(ItemBase.flintAndSteel, 1);
        }
        else
        {
            return instance.getHeldItem();
        }
    }
}

