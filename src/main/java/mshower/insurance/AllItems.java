package mshower.insurance;

import mshower.insurance.utils.ArmorMaterials;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static mshower.insurance.utils.ToolMaterials.BRONZE;

public class AllItems {

    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));
    public static final Item TIN_FOIL = registerItem("tin_foil", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_SWORD = registerItem("bronze_sword", new SwordItem(BRONZE, 3, -2.4F, new Item.Settings()));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel", new ShovelItem(BRONZE, 1.5F, -3.0F, new Item.Settings()));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe", new PickaxeItem(BRONZE, 1, -2.8F, new Item.Settings()));
    public static final Item BRONZE_AXE = registerItem("bronze_axe", new AxeItem(BRONZE, 6.0F, -3.1F, new Item.Settings()));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe", new HoeItem(BRONZE, -2, -1.0F, new Item.Settings()));
    public static final Item BRONZE_HELMET = registerItem("bronze_helmet", new ArmorItem(ArmorMaterials.BRONZE, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate", new ArmorItem(ArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings", new ArmorItem(ArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots", new ArmorItem(ArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, new Item.Settings()));


    public static Item registerItem(String id, Item item) {
        return register(new Identifier(GloriesPersonalInsurance.MOD_ID, id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerItems() {

    }
}
