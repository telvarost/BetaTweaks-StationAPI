package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.container.ContainerBase;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerContainer;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.io.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerBase.class)
public abstract class PlayerBaseMixin extends Living {

    @Shadow public ContainerBase playerContainer;

    public PlayerBaseMixin(Level arg) {
        super(arg);
    }

    @Unique
    private void betaTweaks_clearSlotData(CompoundTag tag, int slotIndex)
    {
        tag.put("ItemID_Slot" + slotIndex, 0);
        tag.put("ItemAmount_Slot" + slotIndex, 0);
        tag.put("ItemDamage_Slot" + slotIndex, 0);
    }

    @Inject(method = "writeCustomDataToTag", at = @At("HEAD"))
    private void betaTweaks_writeCustomDataToTag(CompoundTag tag, CallbackInfo info) {
        if (!Config.ConfigFields.allowCraftingInventorySlots) {
            return;
        }

        PlayerContainer currentCraftingGrid = (PlayerContainer)playerContainer;

        if (null != currentCraftingGrid.craftingInv) {
            for (int slotIndex = 0; slotIndex < 4; ++slotIndex) {
                ItemInstance itemInSlot = currentCraftingGrid.craftingInv.getInventoryItem(slotIndex);
                if (null == itemInSlot) {
                    betaTweaks_clearSlotData(tag, slotIndex);
                }
                else
                {
                    tag.put("ItemID_Slot" + slotIndex, itemInSlot.itemId);
                    tag.put("ItemAmount_Slot" + slotIndex, itemInSlot.count);
                    tag.put("ItemDamage_Slot" + slotIndex, itemInSlot.getDamage());
                }
            }
        }
        else
        {
            /** - Clear all slots */
            betaTweaks_clearSlotData(tag, 0);
            betaTweaks_clearSlotData(tag, 1);
            betaTweaks_clearSlotData(tag, 2);
            betaTweaks_clearSlotData(tag, 3);
        }
    }

    @Inject(method = "readCustomDataFromTag", at = @At("HEAD"))
    private void betaTweaks_readCustomDataFromTag(CompoundTag tag, CallbackInfo info) {
        if (!Config.ConfigFields.allowCraftingInventorySlots) {
            return;
        }

        PlayerContainer currentCraftingGrid = (PlayerContainer)playerContainer;

        if (null != currentCraftingGrid.craftingInv) {
            for (int slotIndex = 0; slotIndex < 4; ++slotIndex) {
                int itemAmount = tag.getInt("ItemAmount_Slot" + slotIndex);

                if (0 != itemAmount)
                {
                    ItemInstance itemToAdd = new ItemInstance( tag.getInt("ItemID_Slot" + slotIndex)
                                                             , itemAmount
                                                             , tag.getInt("ItemDamage_Slot" + slotIndex));
                    currentCraftingGrid.craftingInv.setInventoryItem(slotIndex, itemToAdd);
                }
            }
        }
    }
}
