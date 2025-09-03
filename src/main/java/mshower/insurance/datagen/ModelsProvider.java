package mshower.insurance.datagen;

import mshower.insurance.AllBlocks;
import mshower.insurance.AllItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModelsProvider extends FabricModelProvider {
    public ModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(AllBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AllBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AllBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AllBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AllBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AllBlocks.HALLOWED_BRONZE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AllItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(AllItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(AllItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(AllItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(AllItems.HALLOWED_BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(AllItems.SANCTIFIED_DUST, Models.GENERATED);

        itemModelGenerator.register(AllItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(AllItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(AllItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(AllItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(AllItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(AllItems.HAMDRAX, Models.HANDHELD);
        itemModelGenerator.register(AllItems.HALLOWED_HAMDRAX, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) AllItems.BRONZE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) AllItems.BRONZE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) AllItems.BRONZE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) AllItems.BRONZE_BOOTS);
    }
}
