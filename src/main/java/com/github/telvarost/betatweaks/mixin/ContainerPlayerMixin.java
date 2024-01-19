package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.CraftingResult;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Chest;
import net.minecraft.inventory.Crafting;
import net.minecraft.inventory.InventoryBase;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerContainer.class)
public class ContainerPlayerMixin extends ContainerBase {
    @Shadow public Crafting craftingInv;
    @Shadow public InventoryBase resultInv;
    @Shadow public boolean local;

    public ContainerPlayerMixin(PlayerInventory arg) {
        this(arg, true);
    }

    public ContainerPlayerMixin(PlayerInventory arg, boolean bl) {
        this.craftingInv = new Crafting(this, 2, 2);
        this.resultInv = new Chest();
        this.local = false;
        this.local = bl;
        this.addSlot(new CraftingResult(arg.player, this.craftingInv, this.resultInv, 0, 144, 36));
    }

    @Inject(method = "onClosed", at = @At("HEAD"), cancellable = true)
    public void onClosed(PlayerBase arg, CallbackInfo ci) {
        if (Config.ConfigFields.allowCraftingInventorySlots)
        {
            super.onClosed(arg);
            ci.cancel();
        }
    }


    public boolean canUse(PlayerBase arg) {
        return true;
    }
}