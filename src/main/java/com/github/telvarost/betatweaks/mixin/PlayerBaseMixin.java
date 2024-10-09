package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerBaseMixin extends LivingEntity {

    @Shadow public ScreenHandler playerScreenHandler;

    public PlayerBaseMixin(World arg) {
        super(arg);
    }

    @Unique
    private void betaTweaks_clearSlotData(NbtCompound tag, int slotIndex)
    {
        tag.putInt("ItemID_Slot" + slotIndex, 0);
        tag.putInt("ItemAmount_Slot" + slotIndex, 0);
        tag.putInt("ItemDamage_Slot" + slotIndex, 0);
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    private void betaTweaks_writeCustomDataToTag(NbtCompound tag, CallbackInfo info) {
        if (!Config.config.allowCraftingInventorySlots) {
            return;
        }

        PlayerScreenHandler currentCraftingGrid = (PlayerScreenHandler)playerScreenHandler;

        if (null != currentCraftingGrid.craftingInput) {
            for (int slotIndex = 0; slotIndex < 4; ++slotIndex) {
                ItemStack itemInSlot = currentCraftingGrid.craftingInput.getStack(slotIndex);
                if (null == itemInSlot) {
                    betaTweaks_clearSlotData(tag, slotIndex);
                }
                else
                {
                    tag.putInt("ItemID_Slot" + slotIndex, itemInSlot.itemId);
                    tag.putInt("ItemAmount_Slot" + slotIndex, itemInSlot.count);
                    tag.putInt("ItemDamage_Slot" + slotIndex, itemInSlot.getDamage());
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

    @Inject(method = "readNbt", at = @At("HEAD"))
    private void betaTweaks_readCustomDataFromTag(NbtCompound tag, CallbackInfo info) {
        if (!Config.config.allowCraftingInventorySlots) {
            return;
        }

        PlayerScreenHandler currentCraftingGrid = (PlayerScreenHandler)playerScreenHandler;

        if (null != currentCraftingGrid.craftingInput) {
            for (int slotIndex = 0; slotIndex < 4; ++slotIndex) {
                int itemAmount = tag.getInt("ItemAmount_Slot" + slotIndex);

                if (0 != itemAmount)
                {
                    ItemStack itemToAdd = new ItemStack( tag.getInt("ItemID_Slot" + slotIndex)
                                                             , itemAmount
                                                             , tag.getInt("ItemDamage_Slot" + slotIndex));
                    currentCraftingGrid.craftingInput.setStack(slotIndex, itemToAdd);
                }
            }
        }
    }
}
