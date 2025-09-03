package mshower.insurance.datagen;

import mshower.insurance.AllBlocks;
import mshower.insurance.AllItems;
import mshower.insurance.GloriesPersonalInsurance;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class RecipesProvider extends RecipeProvider {

    public RecipesProvider(DataOutput output) {
        super(output);
    }
    public static final List<ItemConvertible> TIN_INGOT = List.of(AllBlocks.TIN_ORE, AllBlocks.DEEPSLATE_TIN_ORE, AllItems.RAW_TIN);

    public static void offerVanillaEasierSmithingTemplateCopyingRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible template, ItemConvertible resource) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, template, 2)
                .input('#', resource)
                .input('C', Items.DIAMOND)
                .input('S', template)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .criterion(hasItem(template), conditionsFromItem(template))
                .offerTo(exporter, new Identifier(template.toString()));
    }

    public static void offerOwnMultipleOptions(
            Consumer<RecipeJsonProvider> exporter,
            RecipeSerializer<? extends AbstractCookingRecipe> serializer,
            List<ItemConvertible> inputs,
            RecipeCategory category,
            ItemConvertible output,
            float experience,
            int cookingTime,
            String group,
            String method
    ) {
        for (ItemConvertible itemConvertible : inputs) {
            CookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), category, output, experience, cookingTime, serializer)
                    .group(group)
                    .criterion(hasItem(itemConvertible), conditionsFromItem(itemConvertible))
                    .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, (output) + method + "_" + getItemPath(itemConvertible)));
        }
    }

    public static void offerOwnSmeltingOrBlasting(
            Consumer<RecipeJsonProvider> exporter,
            Boolean isSmelting,
            List<ItemConvertible> inputs,
            RecipeCategory category,
            ItemConvertible output,
            float experience,
            int cookingTime,
            String group
    ) {
        if (isSmelting == true) {
            offerOwnMultipleOptions(exporter, RecipeSerializer.SMELTING, inputs, category, output, experience, cookingTime, group, "_from_smelting");
        } else {
            offerOwnMultipleOptions(exporter, RecipeSerializer.BLASTING, inputs, category, output, experience, cookingTime, group, "_from_blasting");
        }
    }
    public static void offerOwnReversibleCompactingRecipes(
            Consumer<RecipeJsonProvider> exporter,
            RecipeCategory reverseCategory,
            ItemConvertible baseItem,
            RecipeCategory compactingCategory,
            ItemConvertible compactItem,
            String compactingId,
            @Nullable String compactingGroup,
            String reverseId,
            @Nullable String reverseGroup
    ) {
        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9)
                .input(compactItem)
                .group(reverseGroup)
                .criterion(hasItem(compactItem), conditionsFromItem(compactItem))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, reverseId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
                .input('#', baseItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(compactingGroup)
                .criterion(hasItem(baseItem), conditionsFromItem(baseItem))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, compactingId));
    }
    public static void offerOwnReversibleCompactingRecipes(
            Consumer<RecipeJsonProvider> exporter,
            RecipeCategory reverseCategory,
            ItemConvertible baseItem,
            RecipeCategory compactingCategory,
            ItemConvertible compactItem,
            String craftBaseRecipeName,
            String craftCompactRecipeItem
    ) {
        offerOwnReversibleCompactingRecipes(
                exporter, reverseCategory, baseItem, compactingCategory, compactItem, craftCompactRecipeItem, null, craftBaseRecipeName, null
        );
    }
    public static void offerHamdraxRecipes(
            Consumer<RecipeJsonProvider> exporter,
            ItemConvertible hamdrax,
            ItemConvertible resource
    ) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hamdrax)
                .input('#', resource)
                .input('|', Items.STICK)
                .pattern("###")
                .pattern("#| ")
                .pattern(" | ")
                .criterion(hasItem(resource), conditionsFromItem(resource))
                .offerTo(exporter, new Identifier(GloriesPersonalInsurance.MOD_ID, hamdrax.toString()));
    }

    @Override

    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerOwnReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, AllBlocks.TIN_BLOCK, "tin_block_to_tin_ingot","tin_ingot_to_tin_block");
        offerOwnReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.RAW_TIN, RecipeCategory.BUILDING_BLOCKS, AllBlocks.RAW_TIN_BLOCK, "raw_tin", "raw_tin_block");
        offerOwnReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.TIN_NUGGET, RecipeCategory.MISC, AllItems.TIN_INGOT,"tin_ingot_to_tin_nugget","tin_nugger_to_tin_ingot");
        offerOwnReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.BRONZE_INGOT, RecipeCategory.BUILDING_BLOCKS, AllBlocks.BRONZE_BLOCK, "bronze_block_to_bronze_ingot", "bronze_ingot_to_bronze_block");
        offerOwnReversibleCompactingRecipes(exporter, RecipeCategory.MISC, AllItems.HALLOWED_BRONZE_INGOT, RecipeCategory.BUILDING_BLOCKS, AllBlocks.HALLOWED_BRONZE_BLOCK, "hallowed_bronze_block_to_hallowed_bronze_ingot", "hallowed_bronze_ingot_to_hallowed_bronze_block");

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

        offerOwnSmeltingOrBlasting(exporter, true, TIN_INGOT, RecipeCategory.MISC, AllItems.TIN_INGOT, 0.7f, 200, "tin_ingot");
        offerOwnSmeltingOrBlasting(exporter, false, TIN_INGOT, RecipeCategory.MISC, AllItems.TIN_INGOT, 0.7f, 100, "tin_ingot");
        offerOwnSmeltingOrBlasting(exporter, false, List.of(AllItems.BRONZE_INGOT), RecipeCategory.MISC, AllItems.HALLOWED_BRONZE_INGOT, 0.7f, 100, "hallowed_bronze_ingot");

        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERRACK);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLESTONE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SANDSTONE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.END_STONE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, Items.NETHERRACK);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLESTONE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLED_DEEPSLATE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, Items.BLACKSTONE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.PURPUR_PILLAR);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.PRISMARINE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLESTONE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLED_DEEPSLATE);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
        offerVanillaEasierSmithingTemplateCopyingRecipes(exporter, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, Items.MOSSY_COBBLESTONE);

        offerHamdraxRecipes(exporter, AllItems.HAMDRAX, AllBlocks.BRONZE_BLOCK);
        offerHamdraxRecipes(exporter, AllItems.HALLOWED_HAMDRAX, AllBlocks.HALLOWED_BRONZE_BLOCK);
    }
}
