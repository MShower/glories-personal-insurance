package mshower.insurance.mixin;
import mshower.insurance.AllItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Set;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
    @Inject(method = "createFuelTimeMap", at = @At("TAIL"))
    private static void addFuels(@NotNull CallbackInfoReturnable<Map<Item, Integer>> cir) {
        cir.getReturnValue().put(AllItems.SANCTIFIED_DUST, 200);
    }
    @Inject(method = "getFuelTime", at = @At("HEAD"), cancellable = true)
    private void restrictFuel(ItemStack fuel, CallbackInfoReturnable<Integer> cir) {
        ItemStack input = ((AbstractFurnaceBlockEntity)(Object)this).getStack(0);
        Set<Item> allowedInputs = Set.of(
                AllItems.BRONZE_INGOT,
                Items.ANCIENT_DEBRIS,
                Items.NETHERITE_SCRAP
        );
        if (!input.isEmpty() && allowedInputs.contains(input.getItem())) {
            if (fuel.isOf(AllItems.SANCTIFIED_DUST)) {
                cir.setReturnValue(200);
            } else {
                cir.setReturnValue(0);
            }
        }
    }
}