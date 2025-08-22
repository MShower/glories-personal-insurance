package mshower.insurance.datagen;

import com.mojang.datafixers.TypeRewriteRule;
import mshower.insurance.AllBlocks;
import mshower.insurance.AllItemGroups;
import mshower.insurance.AllItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class DefaultLanguageProvider extends FabricLanguageProvider {
    public DefaultLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(AllItems.RAW_TIN, "Raw Tin");
        translationBuilder.add(AllItems.TIN_INGOT, "Tin Ingot");
        translationBuilder.add(AllItems.TIN_NUGGET, "Tin Nugget");
        translationBuilder.add(AllItems.TIN_FOIL, "Tin Foil");
        translationBuilder.add(AllItems.BRONZE_INGOT, "Bronze Ingot");

        translationBuilder.add(AllItems.BRONZE_SWORD, "Bronze Sword");
        translationBuilder.add(AllItems.BRONZE_AXE, "Bronze Axe");
        translationBuilder.add(AllItems.BRONZE_HOE, "Bronze Hoe");
        translationBuilder.add(AllItems.BRONZE_PICKAXE, "Bronze Pickaxe");
        translationBuilder.add(AllItems.BRONZE_SHOVEL, "Bronze Shovel");

        translationBuilder.add(AllItems.BRONZE_HELMET, "Bronze Helmet");
        translationBuilder.add(AllItems.BRONZE_CHESTPLATE, "Bronze Chestplate");
        translationBuilder.add(AllItems.BRONZE_LEGGINGS, "Bronze Leggings");
        translationBuilder.add(AllItems.BRONZE_BOOTS, "Bronze Boots");

        translationBuilder.add(AllBlocks.TIN_BLOCK, "Tin Block");
        translationBuilder.add(AllBlocks.RAW_TIN_BLOCK, "Raw Tin Block");
        translationBuilder.add(AllBlocks.TIN_ORE, "Raw Tin Ore");
        translationBuilder.add(AllBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        translationBuilder.add(AllBlocks.BRONZE_BLOCK, "Bronze Block");



        translationBuilder.add(AllItemGroups.INSURANCE_GROUP, "Glorie's Personal Insurance");
    }
}
