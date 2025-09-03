package mshower.insurance.mixin;
import mshower.insurance.AllItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
    @Inject(method = "createFuelTimeMap", at = @At("TAIL"))
    private static void addFuels(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        cir.getReturnValue().put(AllItems.SANCTIFIED_DUST, 200);
    }

    @Shadow
    protected DefaultedList<ItemStack> inventory;

    @Inject(method = "getFuelTime", at = @At("HEAD"), cancellable = true)
    private void restrictFuel(ItemStack fuel, CallbackInfoReturnable<Integer> cir) {
        ItemStack input = inventory.get(0);
        if (input.isOf(AllItems.BRONZE_INGOT)) {
            if (fuel.isOf(AllItems.SANCTIFIED_DUST)) {
                cir.setReturnValue(200);
            } else {
                cir.setReturnValue(0);
            }
        }
    }
}