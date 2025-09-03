package mshower.insurance;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class AllTags {
    public static final TagKey<Block> HAMDRAX_MINEABLE = of("hamdrax_mineable");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(GloriesPersonalInsurance.MOD_ID, id));
    }
}
