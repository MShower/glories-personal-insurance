package mshower.insurance;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AllBlocks {

    public static final Block TIN_BLOCK = register("tin_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RAW_TIN_BLOCK = register("raw_tin_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK)));
    public static final Block TIN_ORE = register("tin_ore", new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block BRONZE_BLOCK = register("bronze_block", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK)));

    public static Block register(String id, Block block) {
        registerAll(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(GloriesPersonalInsurance.MOD_ID, id), block);
    }

    public static void registerAll(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier(GloriesPersonalInsurance.MOD_ID, id),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {

    }
}
