package mshower.insurance.datagen;

import mshower.insurance.AllBlocks;
import mshower.insurance.AllItems;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class RecipesProvider extends RecipeProvider {

    public RecipesProvider(DataOutput output) {
        super(output);
    }

    public static final List<ItemConvertible> TIN_INGOT = List.of(AllBlocks.TIN_ORE, AllBlocks.DEEPSLATE_TIN_ORE, AllItems.RAW_TIN);

/*
Here we have rewritten offerReversibleCompactingRecipes,
replacing the original getRecipeName with two strings to avoid errors caused by duplicate names when generating recipes
*/

    public static void offerReversibleCompactingRecipesSettingNames(
            Consumer<RecipeJsonProvider> exporter,
            RecipeCategory reverseCategory,
            ItemConvertible baseItem,
            RecipeCategory compactingCategory,
            ItemConvertible compactItem,
            String craftBaseRecipeName,
            String craftCompactRecipeItem
    ) {
        offerReversibleCompactingRecipes(
                exporter, reverseCategory, baseItem, compactingCategory, compactItem, craftCompactRecipeItem, null, craftBaseRecipeName, null
        );
    }

    @Override

    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipesSettingNames(exporter, RecipeCategory.MISC, AllItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, AllBlocks.TIN_BLOCK, "tin_block_to_tin_ingot","tin_ingot_to_tin_block");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.RAW_TIN, RecipeCategory.BUILDING_BLOCKS, AllBlocks.RAW_TIN_BLOCK);
        offerReversibleCompactingRecipesSettingNames(exporter, RecipeCategory.MISC, AllItems.TIN_NUGGET, RecipeCategory.MISC, AllItems.TIN_INGOT,"tin_ingot_to_tin_nugget","tin_nugger_to_tin_ingot");

        offerSmelting(exporter, TIN_INGOT, RecipeCategory.MISC, AllItems.TIN_INGOT, 0.7f, 200, "tin_ingot");
        offerBlasting(exporter, TIN_INGOT, RecipeCategory.MISC, AllItems.TIN_INGOT, 0.7f, 100, "tin_ingot");

    }
}
