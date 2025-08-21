package mshower.insurance;

import mshower.insurance.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
	}
}
