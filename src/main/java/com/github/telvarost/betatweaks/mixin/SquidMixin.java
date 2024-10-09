package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.WaterCreatureEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SquidEntity.class)
public class SquidMixin extends WaterCreatureEntity {
    public SquidMixin(World arg) {
        super(arg);
    }

    @Override
    public boolean interact(PlayerEntity arg) {
        if (Config.config.milkSquids) {
            ItemStack var2 = arg.inventory.getSelectedItem();
            if (var2 != null && var2.itemId == Item.BUCKET.id) {
                arg.inventory.setStack(arg.inventory.selectedSlot, new ItemStack(Item.MILK_BUCKET));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
