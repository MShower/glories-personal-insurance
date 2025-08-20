package mshower.insurance;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AllItemGroups {
    public static final RegistryKey<ItemGroup> INSURANCE_GROUP = register("insurance_group");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(GloriesPersonalInsurance.MOD_ID, id));
    }

    public static void registerGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                INSURANCE_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP,7)
                        .displayName(Text.translatable("ItemGroup.insurance_group"))
                        .icon(()-> new ItemStack(AllItems.TIN_INGOT))
                        .entries(((displayContext, entries) -> {
                            entries.add(AllItems.RAW_TIN);
                            entries.add(AllItems.TIN_INGOT);
                            entries.add(AllItems.TIN_NUGGET);
                            entries.add(AllBlocks.TIN_BLOCK);
                        }))
                        .build()
        );
    }
}
