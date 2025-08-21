package mshower.insurance.datagen;

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

        translationBuilder.add(AllBlocks.TIN_BLOCK, "Tin Block");
        translationBuilder.add(AllBlocks.RAW_TIN_BLOCK, "Raw Tin Block");
        translationBuilder.add(AllBlocks.TIN_ORE, "Raw Tin Ore");
        translationBuilder.add(AllBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");

        translationBuilder.add(AllItemGroups.INSURANCE_GROUP, "Glorie's Personal Insurance");
    }
}
