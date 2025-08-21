package mshower.insurance;

import mshower.insurance.datagen.*;
import mshower.insurance.world.ConfiguredFeatures;
import mshower.insurance.world.PlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class GloriesPersonalInsuranceDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockLootTablesProvider::new);
        pack.addProvider(BlockTagsProvider::new);
        pack.addProvider(DefaultLanguageProvider::new);
        pack.addProvider(ItemTagsProvider::new);
        pack.addProvider(ModelsProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.Factory<RecipesProvider>) RecipesProvider::new);
        pack.addProvider(WorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures::bootstrap);
    }
}
