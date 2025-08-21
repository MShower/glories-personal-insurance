package mshower.insurance.datagen;

import mshower.insurance.AllBlocks;
import mshower.insurance.AllItems;
import mshower.insurance.GloriesPersonalInsurance;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

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
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.BRONZE_INGOT, RecipeCategory.BUILDING_BLOCKS, AllBlocks.BRONZE_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AllItems.BRONZE_INGOT, 2)
                .input('#', AllItems.TIN_NUGGET)
                .input('$', Items.COPPER_INGOT)
                .pattern("#$")
                .pattern("$#")
                .criterion(hasItem(AllItems.TIN_NUGGET), conditionsFromItem(AllItems.TIN_NUGGET))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, "bronze_ingot"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AllItems.BRONZE_AXE)
                .input('#', AllItems.BRONZE_INGOT)
                .input('|', Items.STICK)
                .pattern("##")
                .pattern("#|")
                .pattern(" |")
                .criterion(hasItem(AllItems.BRONZE_INGOT), conditionsFromItem(AllItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, "bronze_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AllItems.BRONZE_HOE)
                .input('#', AllItems.BRONZE_INGOT)
                .input('|', Items.STICK)
                .pattern("##")
                .pattern("| ")
                .pattern("| ")
                .criterion(hasItem(AllItems.BRONZE_INGOT), conditionsFromItem(AllItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, "bronze_hoe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AllItems.BRONZE_SHOVEL)
                .input('#', AllItems.BRONZE_INGOT)
                .input('|', Items.STICK)
                .pattern("#")
                .pattern("|")
                .pattern("|")
                .criterion(hasItem(AllItems.BRONZE_INGOT), conditionsFromItem(AllItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, "bronze_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AllItems.BRONZE_SWORD)
                .input('#', AllItems.BRONZE_INGOT)
                .input('|', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("|")
                .criterion(hasItem(AllItems.BRONZE_INGOT), conditionsFromItem(AllItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, "bronze_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AllItems.BRONZE_PICKAXE)
                .input('#', AllItems.BRONZE_INGOT)
                .input('|', Items.STICK)
                .pattern("###")
                .pattern(" | ")
                .pattern(" | ")
                .criterion(hasItem(AllItems.BRONZE_INGOT), conditionsFromItem(AllItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, "bronze_pickaxe"));

        offerSmelting(exporter, TIN_INGOT, RecipeCategory.MISC, AllItems.TIN_INGOT, 0.7f, 200, "tin_ingot");
        offerBlasting(exporter, TIN_INGOT, RecipeCategory.MISC, AllItems.TIN_INGOT, 0.7f, 100, "tin_ingot");

    }
}
