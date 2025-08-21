package mshower.insurance.datagen;

import mshower.insurance.AllBlocks;
import mshower.insurance.AllItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class BlockLootTablesProvider extends FabricBlockLootTableProvider {
    public BlockLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(AllBlocks.TIN_BLOCK);
        addDrop(AllBlocks.RAW_TIN_BLOCK);
        addDrop(AllBlocks.BRONZE_BLOCK);

        addDrop(AllBlocks.TIN_ORE, oreDrops(AllBlocks.TIN_ORE, AllItems.RAW_TIN));
        addDrop(AllBlocks.DEEPSLATE_TIN_ORE, oreDrops(AllBlocks.DEEPSLATE_TIN_ORE, AllItems.RAW_TIN));
    }
}
