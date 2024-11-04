package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.toast.AchievementToast;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(AchievementToast.class)
public class AchievementMixin extends DrawContext {
    @Shadow
    private Minecraft client;
    @Shadow
    private ItemRenderer itemRenderer;

    public AchievementMixin(Minecraft minecraft) {
        this.client = minecraft;
        this.itemRenderer = new ItemRenderer();
    }

    @Inject(
            method = "set",
            at = @At("HEAD"),
            cancellable = true
    )
    public void setAchievementGet(net.minecraft.achievement.Achievement arg, CallbackInfo ci) {
        if (Config.config.hideAchievementNotifications)
        {
            ci.cancel();
        }
    }
}