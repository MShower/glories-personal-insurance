package mshower.insurance.utils.world.generation;

import mshower.insurance.utils.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class OreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PlacedFeatures.TIN_ORE_PLACED_KEY);
    }
}
