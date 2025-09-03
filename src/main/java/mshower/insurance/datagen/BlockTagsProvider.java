package mshower.insurance.datagen;

import com.mojang.datafixers.TypeRewriteRule;
import mshower.insurance.AllBlocks;
import mshower.insurance.AllTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(AllBlocks.TIN_BLOCK)
                .add(AllBlocks.RAW_TIN_BLOCK)
                .add(AllBlocks.TIN_ORE)
                .add(AllBlocks.DEEPSLATE_TIN_ORE)
                .add(AllBlocks.BRONZE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(AllBlocks.TIN_BLOCK)
                .add(AllBlocks.TIN_ORE)
                .add(AllBlocks.DEEPSLATE_TIN_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(AllBlocks.BRONZE_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(AllBlocks.HALLOWED_BRONZE_BLOCK);

        getOrCreateTagBuilder(AllTags.HAMDRAX_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE);
    }
}
