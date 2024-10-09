package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerScreenHandler.class)
public class PlayerContainerMixin extends ScreenHandler {

    public PlayerContainerMixin(PlayerInventory inventory) {
        this(inventory, true);
    }

    public PlayerContainerMixin(PlayerInventory arg, boolean bl) {
    }

    @Inject(method = "onClosed", at = @At("HEAD"), cancellable = true)
    public void onClosed(PlayerEntity arg, CallbackInfo ci) {
        if (Config.config.allowCraftingInventorySlots)
        {
            super.onClosed(arg);
            ci.cancel();
        }
    }


    public boolean canUse(PlayerEntity arg) {
        return true;
    }
}
