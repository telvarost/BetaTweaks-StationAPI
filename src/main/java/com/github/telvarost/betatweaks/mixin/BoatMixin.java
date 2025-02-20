package com.github.telvarost.betatweaks.mixin;

import com.github.telvarost.betatweaks.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/*
 * Thanks to EOfSL for the original solution: https://github.com/EOfSL
 */
@Mixin(BoatEntity.class)
abstract class BoatMixin extends Entity {
    public BoatMixin(World level) {
        super(level);
    }

    @ModifyConstant(method = "tick", constant = @Constant(doubleValue = 1.0, ordinal = 1))
    private double betaTweaks_elevatorBoatCondition(double d) {
        if (Config.config.elevatorBoats) {
            return Double.MAX_VALUE;
        } else {
            return d;
        }
    }

//    @Inject(
//            method = "tick",
//            at = @At("RETURN"),
//            cancellable = true
//    )
//    private void betaTweaks_alternateElevatorBoatCondition(CallbackInfo ci) {
//        if (Config.config.elevatorBoats) {
//            byte var1 = 5;
//            double var2 = 0.0;
//
//            for (int var4 = 0; var4 < var1; ++var4) {
//                double var5 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double) (var4 + 0) / (double) var1 - 0.125;
//                double var7 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double) (var4 + 1) / (double) var1 - 0.125;
//                Box var9 = Box.createCached(this.boundingBox.minX, var5, this.boundingBox.minZ, this.boundingBox.maxX, var7, this.boundingBox.maxZ);
//                if (this.world.isFluidInBox(var9, Material.WATER)) {
//                    var2 += 1.0 / (double) var1;
//                }
//            }
//
//            if (var2 >= 1.0D) {
//                double d3 = var2 * 2D - 1.0D;
//                this.move(0, (0.039999999105930328D * d3) / 2.5D - 0.0070000002160668373D, 0);
//            }
//        }
//    }
}
