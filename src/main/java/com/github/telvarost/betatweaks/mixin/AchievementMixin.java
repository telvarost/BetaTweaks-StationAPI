package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Achievement;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.entity.ItemRenderer;
import net.minecraft.client.resource.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(Achievement.class)
public class AchievementMixin extends DrawableHelper {
    @Shadow
    private Minecraft minecraft;
    @Shadow
    private ItemRenderer itemRenderer;

    public AchievementMixin(Minecraft minecraft) {
        this.minecraft = minecraft;
        this.itemRenderer = new ItemRenderer();
    }

    @Inject(
            method = "setAchievementGet",
            at = @At("HEAD"),
            cancellable = true
    )
    public void setAchievementGet(net.minecraft.achievement.Achievement arg, CallbackInfo ci) {
        if (Config.ConfigFields.hideAchievementNotifications)
        {
            ci.cancel();
        }
    }
}