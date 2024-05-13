package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.swimming.Squid;
import net.minecraft.entity.swimming.SwimmingBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Squid.class)
public class SquidMixin extends SwimmingBase {
    public SquidMixin(Level arg) {
        super(arg);
    }

    @Override
    public boolean interact(PlayerBase arg) {
        if (Config.config.milkSquids) {
            ItemInstance var2 = arg.inventory.getHeldItem();
            if (var2 != null && var2.itemId == ItemBase.bucket.id) {
                arg.inventory.setInventoryItem(arg.inventory.selectedHotbarSlot, new ItemInstance(ItemBase.milk));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
